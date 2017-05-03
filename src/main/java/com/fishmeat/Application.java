package com.fishmeat;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sggb
 * @since 18.04.2017
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
public class Application {

    @Autowired
    private Service service;

    @RequestMapping("/")
    public String home() {
        return service.hello();
    }

    @Bean
    Service service() {
        return new Service();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
