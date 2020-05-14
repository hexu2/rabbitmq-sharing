package com.hexu.rabbitmq.route;


import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteConsumer {


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key = {"info","error","warn"}
            )
    })
    public void receive1(String message) {
        System.out.println("receive1 message = [" + message + "]");
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key = {"error"}
            )
    })
    public void receive2(String message) {
        System.out.println("receive2 message = [" + message + "]");
    }
}
