package com.wr.estoqueapi.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DiminuirEstoqueConsumer {
    @RabbitListener(queues = {"decrease-estoque"})
    public void consumeDiminuiEstoque(@Payload String body) throws IOException{
        System.out.println(body);
    }
}
