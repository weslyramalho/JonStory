package com.wr.lojabff.controllers;

import com.wr.lojabff.adapters.requests.ProdutoCriacaoRequest;
import com.wr.lojabff.adapters.responses.ProdutoCriacaoResponse;
import com.wr.lojabff.clients.ProdutoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    @Autowired
    ProdutoClient produtoClient;

    @PostMapping
    public ResponseEntity<ProdutoCriacaoResponse> criar(@RequestBody ProdutoCriacaoRequest novoProduto) throws IOException{
        ProdutoCriacaoResponse produto = produtoClient.createProduct(novoProduto);

        if(produto != null)
            return new ResponseEntity<>(produto, HttpStatus.CREATED);

        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoCriacaoResponse>> listarTodos() throws IOException{
        List<ProdutoCriacaoResponse> produtos = produtoClient.listProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
