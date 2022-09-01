package com.wr.produtos.services;

import com.wr.produtos.entities.Produto;
import com.wr.produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscar(UUID id){
        return produtoRepository.findById(id).orElseThrow();
    }

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }
}
