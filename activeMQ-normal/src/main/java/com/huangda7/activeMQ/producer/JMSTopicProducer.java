package com.huangda7.activeMQ.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSTopicProducer {
    public static final String ACTIVEMQ_SERVICE_URL = "tcp://192.168.0.100:61616";
    public static final String TOPIC_NAME = "HUANGDA7_TOPIC";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_SERVICE_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //第一个参数决定是不是开启事务，第二个与签收有关
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建消息的生产者
        MessageProducer producer = session.createProducer(topic);
        for (int i = 1; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("生产者发送的第" + i + "条消息");
            producer.send(textMessage);
        }
        //关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("消息发布到MQ Topic完成！");
    }
}
