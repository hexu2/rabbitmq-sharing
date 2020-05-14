package com.hexu.rabbitmq;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSharingApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitmq {

    //注入
    @Autowired
    private RabbitTemplate rabbitTemplate;


    //hello
    @Test
    public void testHello(){

        rabbitTemplate.convertAndSend("hello","Hello World!!");
    }

    //Work
    @Test
    public void testWork(){
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("work","work 模型 " + i);
        }

    }


    //fanout 模式
    @Test
    public void testFanout(){

        rabbitTemplate.convertAndSend("logs","","Messages send by fanout!!");
    }

    //route 模式
    @Test
    public void testRout(){
        rabbitTemplate.convertAndSend("directs","error","发送了error key的路由信息！！");
    }


    //topics 动态路由模式
    @Test
    public void testTopic(){

        rabbitTemplate.convertAndSend("topics","product.user.save","toptics 发送了user.save的信息！！\"");
    }
}
