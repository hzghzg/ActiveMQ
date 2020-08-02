package com.huangda7.springbootactivemq.config;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProducerConfig {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private ActiveMQQueue queue;

    public void produceMessage() {
        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0,6));
    }
}
