package com.mytech.articleservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMQ {

    @RabbitListener(queues = ArticleserviceApplication.queueName)
    public void receiveMessage(String message) throws JsonProcessingException {

        System.out.println("Received message: \n" + message);
    }
}
