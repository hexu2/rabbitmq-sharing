package com.hexu.rabbitmq.helloworld;

import com.hexu.rabbitmq.utils.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Provider {


    public static void main(String[] args) throws Exception{
        Connection connection = RabbitmqUtils.getConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare("hello.queue",false,false,false, null);

        for(int i = 1; i <= 20; i++){
            channel.basicPublish("","hello.queue", null, ("Hello rabbitmq " + i ).getBytes());

        }


        connection.close();
        channel.close();
    }
}
