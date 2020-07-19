package com.lele.springboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuan
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}

}
