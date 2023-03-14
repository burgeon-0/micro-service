package org.bg181.ms.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Nacos 启动类
 * 需要先启动 Nacos 服务：sh startup.sh -m standalone
 *
 * @author lxc
 * @date 2023/03/10
 */
@SpringBootApplication
@EnableDiscoveryClient // 自动将服务注册到 Nacos 中，自动发现 Nacos 中的服务
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }

}
