package com.huangda7.springbootactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringbootactivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootactivemqApplication.class, args);
    }

}
