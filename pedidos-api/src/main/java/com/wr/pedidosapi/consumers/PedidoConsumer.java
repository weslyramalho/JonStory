package com.wr.pedidosapi.consumers;

import com.google.gson.Gson;
import com.wr.pedidosapi.clients.EstoqueClient;
import com.wr.pedidosapi.entities.Pedido;
import com.wr.pedidosapi.entities.ProdutoEstoque;
import com.wr.pedidosapi.producers.PedidoProducer;
import com.wr.pedidosapi.services.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PedidoConsumer {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private EstoqueClient estoqueClient;

    @Autowired
    private PedidoProducer pedidoProducer;

    @RabbitListener(queues = {"CRIADO-PEDIDO"})
    public void conumeCriarPedido(@Payload String body) throws IOException{
        Gson gson = new Gson();
        Pedido pedido = gson.fromJson(body, Pedido.class);

        ProdutoEstoque produtoEstoque = estoqueClient.getProductStock(pedido.getProdutoId());
        Pedido pedidoCriar = pedidoService.criar(pedido, produtoEstoque);

        if(pedidoCriar != null)
            pedidoProducer.producePedidoCriado(pedidoCriar);
    }
}
