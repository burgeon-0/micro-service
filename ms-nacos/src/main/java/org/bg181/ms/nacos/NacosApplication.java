package org.bg181.ms.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Nacos 启动类
 *
 * @author lxc
 * @date 2023/03/10
 */
@SpringBootApplication
@NacosPropertySource(groupId = "ms", dataId = "notebook", autoRefreshed = true)
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }

}
