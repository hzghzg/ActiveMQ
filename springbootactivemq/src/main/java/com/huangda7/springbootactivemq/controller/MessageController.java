package com.huangda7.springbootactivemq.controller;

import com.huangda7.springbootactivemq.config.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private ProducerConfig producerConfig;
    @GetMapping(path = "/test")
    public String triggerProduceMessage(){
        producerConfig.produceMessage();
        return "生产消息完成！";
    }
}
