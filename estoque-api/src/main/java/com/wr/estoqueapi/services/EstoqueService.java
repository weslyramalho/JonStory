package com.wr.estoqueapi.services;

import com.wr.estoqueapi.clients.ProdutoClient;
import com.wr.estoqueapi.entities.Estoque;
import com.wr.estoqueapi.entities.ProdutoEstoque;
import com.wr.estoqueapi.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoClient produtoClient;

    private boolean verSeProdutoExiste(Estoque estoque) throws IOException{
        return produtoClient.getById(estoque.getProdutoId()) != null;
    }

    public Estoque criar(Estoque estoque) throws IOException{
        if(verSeProdutoExiste(estoque))
            return estoqueRepository.save(estoque);
        return null;
    }

    public Estoque buscar(UUID id){
        return estoqueRepository.findById(id).orElseThrow();
    }
    public List<Estoque> buscarTodos(){
        return estoqueRepository.findAll();
    }

    public ProdutoEstoque porProduto(UUID produtoId){
        List<Estoque> estoques = estoqueRepository.findAll();

        List<Estoque> produtoEstoque = estoques.stream().filter(estoque -> estoque.getProdutoId().equals(produtoId)).toList();
        List<Integer> quantidades = produtoEstoque.stream().map(Estoque::getQuantidade).toList();
        int quantidadeDisponivel = quantidades.stream().reduce(0, Integer::sum);

        return new ProdutoEstoque(produtoId, quantidadeDisponivel);
    }


}
