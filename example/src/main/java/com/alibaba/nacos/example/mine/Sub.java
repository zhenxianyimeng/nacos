package com.alibaba.nacos.example.mine;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

/**
 * Description:
 *
 * @author: chixiao
 * @date: 2020-01-16
 * @time: 19:22
 */
public class Sub {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serviceName = "helloworld.services";
        NamingService namingService = NamingFactory.createNamingService("127.0.0.1:8848");

        namingService.subscribe(serviceName, event -> {
            if (event instanceof NamingEvent) {
                NamingEvent namingEvent = ((NamingEvent) event);
                System.out.println(namingEvent.getInstances());
            }
        });
        System.out.println("订阅完成");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
