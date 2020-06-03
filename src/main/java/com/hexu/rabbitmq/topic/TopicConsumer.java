package com.hexu.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(name = "topics",type = "topic"),
                    key = {"user.save","user.*"}
            )
    })
    public void receive1(String message){

        System.out.println("receive1 message = [" + message + "]");

    }


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(name = "topics",type = "topic"),
                    key = {"order.#","product.#","user.*"}
            )
    })
    public void receive2(String message){

        System.out.println("receive2 message = [" + message + "]");



    }
}
