package com.fishmeat.config.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author sggb
 * @since 03.05.2017
 */
public class Service {

    @HystrixCommand
    String hello() {
        return "Hello World!";
    }
}
