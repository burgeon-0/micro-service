package org.bg181.ms.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Nacos 启动类
 * 需要先启动 Nacos 服务：sh startup.sh -m standalone
 *
 * @author lxc
 * @date 2023/03/10
 */
@SpringBootApplication
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }

}
