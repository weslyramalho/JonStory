package com.wr.produtos.adapters;

import com.google.gson.Gson;
import com.wr.produtos.adapters.requests.ProdutoCreationRequest;
import com.wr.produtos.entities.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoAdapter {
    public String toJson(ProdutoCreationRequest produtoCreationRequest){
        Gson gson = new Gson();
        return gson.toJson(produtoCreationRequest);
    }
    public Produto fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Produto.class);
    }
}
