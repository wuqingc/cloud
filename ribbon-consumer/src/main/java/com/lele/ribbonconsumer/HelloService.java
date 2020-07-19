package com.lele.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author xuan
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class)
                .getBody();
    }

    public String helloFallback(){
        return "error";
    }
}
