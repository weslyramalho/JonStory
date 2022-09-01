package com.wr.estoqueapi.adapters;

import com.wr.estoqueapi.adapters.requests.EstoqueCriarRequest;
import com.wr.estoqueapi.adapters.responses.EstoqueCriarResponse;
import com.wr.estoqueapi.entities.Estoque;
import org.springframework.stereotype.Component;

@Component
public class EstoqueAdapter {
    public Estoque paraEstoque(EstoqueCriarRequest estoqueCriarRequest){
        return Estoque.builder()
                .produtoId(estoqueCriarRequest.produtoId())
                .quantidade(estoqueCriarRequest.quantidade())
                .quantidadeDisponivel(estoqueCriarRequest.quantidade())
                .build();
    }

    public EstoqueCriarResponse paraEstoqueCriarResponse(Estoque estoque){
        return EstoqueCriarResponse.builder()
                .id(estoque.getId())
                .produtoId(estoque.getProdutoId())
                .quantidade(estoque.getQuantidade())
                .quantidadeDisponivel(estoque.getQuantidadeDisponivel())
                .build();
    }
}
