package org.bg181.ms.nacos.user;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.bg181.ms.nacos.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户接口
 *
 * @author lxc
 * @date 2023/03/11
 */
@Slf4j
@RestController
@RequestMapping("/api/users")
@RefreshScope
public class UserController {

    /**
     * 从配置服务拉取配置
     */
    @Value(value = "${showAccessLog:false}")
    private boolean showAccessLog;

    @GetMapping
    public List<User> getUsers(@RequestParam List<Long> userIds, HttpServletRequest request) {
        if (showAccessLog) {
            log.info("{} {}", request.getMethod(), request.getRequestURI());
        }

        return userIds.stream()
                .map(id -> new User(id,
                        StrUtil.format("昵称{}", RandomUtil.randomString(2)),
                        "http://example.com/avatar"))
                .collect(Collectors.toList());
    }

}
