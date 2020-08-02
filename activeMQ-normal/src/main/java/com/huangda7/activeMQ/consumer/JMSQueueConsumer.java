package com.huangda7.activeMQ.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JMSQueueConsumer {
    public static final String ACTIVEMQ_SERVICE_URL = "tcp://192.168.0.100:61616";
    public static final String QUEUE_NAME = "HUANGDA7_QUEUE";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_SERVICE_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //第一个参数决定是不是开启事务，第二个与签收有关
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
//        while (true) {
//            //receive方法可以加上参数表示等待的时间，没有消息则结束消费
//            TextMessage receive = (TextMessage) consumer.receive();
//            if (receive != null) {
//                System.out.println("接收到消息:" + receive.getText());
//            } else {
//                break;
//            }
//        }
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("消费者通过监听器消费到消息:"+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //如果不加这句话，没有消费到消息程序就关闭了
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
