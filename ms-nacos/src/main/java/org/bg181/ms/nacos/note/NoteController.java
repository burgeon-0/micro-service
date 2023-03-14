package org.bg181.ms.nacos.note;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 笔记接口
 *
 * @author lxc
 * @date 2023/03/13
 */
@Slf4j
@RestController
@RequestMapping("/api/notes")
@RefreshScope
@RequiredArgsConstructor
public class NoteController {

    private final RestTemplate restTemplate;

    /**
     * 从配置服务拉取配置
     */
    @Value(value = "${showAccessLog:false}")
    private boolean showAccessLog;

    @GetMapping
    public List<Note> getNotes(HttpServletRequest request) {
        if (showAccessLog) {
            log.info("{} {}", request.getMethod(), request.getRequestURI());
        }

        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1L, "note1", "xxxx", 123456789012345678L, null));
        notes.add(new Note(2L, "note2", "yyyy", 223456789012345678L, null));

        // 自动解析 ms-nacos 地址
        List list = restTemplate.getForObject(
                "http://ms-nacos/api/users?userIds=123456789012345678&userIds=223456789012345678",
                List.class);
        Map<Long, String> userNicknameMap = new HashMap();
        list.forEach(user -> {
            Map<String, Object> userMap = (Map<String, Object>) user;
            userNicknameMap.put(((Long) userMap.get("id")).longValue(), (String) userMap.get("nickname"));
        });

        notes.forEach(note -> {
            note.setUserNickname(userNicknameMap.get(note.getUserId()));
        });
        return notes;
    }

}
