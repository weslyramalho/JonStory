package com.wr.produtos.producers;

import com.wr.produtos.adapters.ProdutoAdapter;
import com.wr.produtos.adapters.requests.ProdutoCreationRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {

    @Autowired
    private final AmqpTemplate amqpTemplate;

    @Autowired
    private ProdutoAdapter produtoAdapter;

    public ProdutoProducer(AmqpTemplate template){
        this.amqpTemplate = template;
    }

    public void publicCriarProduto(ProdutoCreationRequest produtoCreationRequest){
        String payload = produtoAdapter.toJson(produtoCreationRequest);
        amqpTemplate.convertAndSend("CREATE-PRODUTO", payload);
    }

}
