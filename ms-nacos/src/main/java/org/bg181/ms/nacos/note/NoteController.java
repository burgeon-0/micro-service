package org.bg181.ms.nacos.note;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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
public class NoteController {

    @Value(value = "${showAccessLog:false}")
    private boolean showAccessLog;

    @GetMapping
    public List<Note> getNotes(HttpServletRequest request) {
        if (showAccessLog) {
            log.info("{} {}", request.getMethod(), request.getRequestURI());
        }

        return new ArrayList<>();
    }

}
