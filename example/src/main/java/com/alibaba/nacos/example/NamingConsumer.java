package com.alibaba.nacos.example;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.Properties;

/**
 * Description:
 *
 * @author: chixiao
 * @date: 2020-04-10
 * @time: 17:17
 */
public class NamingConsumer {
    public static void main(String[] args) throws NacosException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "localhost");
        properties.setProperty("namespace", "e3d3d6e3-d48e-4455-b7db-7c5ef826e134");

        NamingService namingService = NamingFactory.createNamingService(properties);

        namingService.subscribe("nacos.test.3", new EventListener() {
            @Override
            public void onEvent(Event event) throws NacosException {
                for (int i = 0; i <5 ; i++) {
                    Instance instance = namingService.selectOneHealthyInstance("nacos.test.3");
                    System.out.println(instance);
                }
            }
        });
        Thread.sleep(3000000);
    }
}
