package com.yupi.springbootinit.bizmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class BiIniMain {

    public static void main(String[] args) {
        try {
            ConnectionFactory factory=new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection=factory.newConnection();
            Channel channel=connection.createChannel();
            String EXCHANGE_NAME = BiMqConstant.BI_EXCHANGE_NAME;
            channel.exchangeDeclare(EXCHANGE_NAME,"direct");

            //创建队列，随机分配一个队列名称

            channel.queueDeclare(BiMqConstant.BI_QUEUE_NAME,true,false,false,null);
            channel.queueBind(BiMqConstant.BI_QUEUE_NAME,EXCHANGE_NAME,BiMqConstant.BI_ROUTING_KEY);
        }catch (Exception e) {}
    }
}
