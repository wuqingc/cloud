package com.lele.springboothello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author xuan
 * SpringBoot：除Maven外，没有用到其他的xml文件.
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 拿到当前服务的相关信息
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();

        /*
         * Hystrix默认超时时间为2000ms,超时后触发熔断机制.
         */
        int sleepTime = new Random().nextInt(3000);

        Thread.sleep(sleepTime);

        long end = System.currentTimeMillis();


        logger.info("Spend Time: " + (end - start));
        logger.info("/hello,host: " + serviceInstance.getHost() +
                ", service_id: " + serviceInstance.getServiceId());
        return "hello boot.";
    }
}
