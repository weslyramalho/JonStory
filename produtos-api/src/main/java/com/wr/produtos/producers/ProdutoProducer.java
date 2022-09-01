package com.wr.produtos.producers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {

    @Autowired
    private final AmqpTemplate amqpTemplate;

}
