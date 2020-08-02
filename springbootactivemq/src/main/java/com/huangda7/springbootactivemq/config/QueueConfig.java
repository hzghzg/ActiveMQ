package com.huangda7.springbootactivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public ActiveMQQueue getActiveMQQueue() {
        return new ActiveMQQueue("Huangda7_Springboot_Queue");
    }
}
