package com.hexu.rabbitmq.helloworld;

import com.hexu.rabbitmq.utils.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello.queue", true, false, false, null);
        channel.basicConsume("hello.queue", true, new DefaultConsumer(channel) {


            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                try {
                    Thread.sleep(200000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Customer-1: Message from queue = " + new String(body));
            }
        });

//        RabbitmqUtils.closeConnectionAndChannel(connection,channel);

    }


}
