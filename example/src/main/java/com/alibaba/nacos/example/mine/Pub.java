package com.alibaba.nacos.example.mine;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

/**
 * Description:
 *
 * @author: chixiao
 * @date: 2020-01-16
 * @time: 19:20
 */
public class Pub {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serviceName = "helloworld.services";
        NamingService namingService = NamingFactory.createNamingService("127.0.0.1:8848");

        namingService.registerInstance(serviceName, "127.0.0.1", 8080);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
