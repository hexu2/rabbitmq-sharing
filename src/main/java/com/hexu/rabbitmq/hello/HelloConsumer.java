package com.hexu.rabbitmq.hello;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "true"))
public class HelloConsumer {


    @RabbitHandler
    public void received(String message){

        System.out.println("received  message = " + message);
    }



}
