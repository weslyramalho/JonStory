package com.wr.produtos.consumers;

import com.wr.produtos.adapters.ProdutoAdapter;
import com.wr.produtos.entities.Produto;
import com.wr.produtos.services.ProdutoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {

    @Autowired
    private ProdutoAdapter produtoAdapter;

    @Autowired
    private ProdutoService produtoService;

    @RabbitListener(queues = {"CREATE-PRODUTO"})
    public void criarProduto(@Payload String body){
        Produto produto = produtoAdapter.fromJson(body);
        produtoService.criar(produto);
    }
}
