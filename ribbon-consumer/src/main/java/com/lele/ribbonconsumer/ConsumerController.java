package com.lele.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationEvent;

/**
 * @author xuan
 */
@RestController
public class ConsumerController {
//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
//        // 输出当前客户端维护的hello-service列表,Ribbon按照此信息进行轮询访问(实现负载均衡).
//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class)
//                .getBody();
        return helloService.helloService();
    }
}
