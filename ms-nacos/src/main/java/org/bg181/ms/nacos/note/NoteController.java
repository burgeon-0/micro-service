package org.bg181.ms.nacos.note;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
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
public class NoteController {

    @NacosValue(value = "${showAccessLog:false}", autoRefreshed = true)
    private boolean showAccessLog;

    @GetMapping
    public List<Note> getNotes(HttpServletRequest request) {
        if (showAccessLog) {
            log.info("{} {}", request.getMethod(), request.getRequestURI());
        }

        return new ArrayList<>();
    }

}
