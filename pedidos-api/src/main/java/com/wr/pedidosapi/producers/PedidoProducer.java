package com.wr.pedidosapi.producers;

import com.google.gson.Gson;
import com.wr.pedidosapi.entities.Pedido;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {

    @Autowired
    private final AmqpTemplate amqpTemplate;

    Gson gson = new Gson();


    public PedidoProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void producerCriarPedido(Pedido pedido){
        String payload = gson.toJson(pedido);
        amqpTemplate.convertAndSend("CRIADO-PEDIDO", payload);
    }

    public void producePedidoCriado(Pedido pedido){
        String payload = gson.toJson(pedido);
        amqpTemplate.convertAndSend("pedido-exchange", "pedido-routing-key", payload);
    }
}
