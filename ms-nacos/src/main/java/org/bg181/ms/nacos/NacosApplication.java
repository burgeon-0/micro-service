package org.bg181.ms.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Nacos 示例 启动类
 *
 * @author lxc
 * @date 2023/03/10
 */
@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true) // 指定配置的 dataId
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }

}
