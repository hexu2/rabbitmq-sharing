package com.hexu.rabbitmq.helloworld;

import com.hexu.rabbitmq.utils.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello.queue", true, false, false, null);
        channel.basicConsume("hello.queue", true, new DefaultConsumer(channel) {


            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Customer-2: Message String from queue = " + new String(body));
            }
        });

//        RabbitmqUtils.closeConnectionAndChannel(connection,channel);

    }


}
