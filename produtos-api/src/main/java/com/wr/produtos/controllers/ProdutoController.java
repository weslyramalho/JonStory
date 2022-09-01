package com.wr.produtos.controllers;

import com.wr.produtos.adapters.requests.ProdutoCreationRequest;
import com.wr.produtos.entities.Produto;
import com.wr.produtos.producers.ProdutoProducer;
import com.wr.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoProducer produtoProducer;

    @PostMapping()
    public ResponseEntity criar(@RequestBody ProdutoCreationRequest produtoCreationRequest){
        produtoProducer.publicCriarProduto(produtoCreationRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> busca(@PathVariable UUID id){
        Produto produto = produtoService.buscar(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> produtos = produtoService.buscarTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
