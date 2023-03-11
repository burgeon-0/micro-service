package org.bg181.ms.nacos.asample;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Nacos 服务发现类
 *
 * @author lxc
 * @date 2023/03/10
 */
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    /**
     * 通过调用 Nacos Open API 向 Nacos server 注册一个名称为 example 服务
     * curl -X POST 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=example&ip=127.0.0.1&port=8080'
     *
     * @param serviceName
     * @return
     * @throws NacosException
     */
    @GetMapping("/get")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

}
