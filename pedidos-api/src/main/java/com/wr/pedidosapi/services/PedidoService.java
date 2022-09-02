package com.wr.pedidosapi.services;

import com.wr.pedidosapi.entities.Pedido;
import com.wr.pedidosapi.entities.ProdutoEstoque;
import com.wr.pedidosapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criar(Pedido pedido, ProdutoEstoque produtoEstoque){
        if(pedido.getQuantidade() <= produtoEstoque.getQuantidadeDisponivel())
            return pedidoRepository.save(pedido);
        return null;
    }

    public List<Pedido> buscarTodos(){
        return pedidoRepository.findAll();
    }
}
