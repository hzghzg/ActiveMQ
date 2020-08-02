package com.huangda7.activeMQ.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {
    public static final String ACTIVEMQ_SERVICE_URL = "tcp://192.168.0.100:61616";
    public static final String QUEUE_NAME = "HUANGDA7_QUEUE";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_SERVICE_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //第一个参数决定是不是开启事务，第二个与签收有关
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            TextMessage receive = (TextMessage) consumer.receive();
            if (receive != null) {
                System.out.println("接收到消息:" + receive.getText());
            } else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
    }
}
