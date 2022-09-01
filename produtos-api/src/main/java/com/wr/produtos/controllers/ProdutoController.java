package com.wr.produtos.controllers;

import com.wr.produtos.adapters.requests.ProdutoCreationRequest;
import com.wr.produtos.producers.ProdutoProducer;
import com.wr.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoProducer produtoProducer;

    @PostMapping()
    public ResponseEntity criar(@RequestBody ProdutoCreationRequest produtoCreationRequest){
        produtoProducer.publish
    }
}
