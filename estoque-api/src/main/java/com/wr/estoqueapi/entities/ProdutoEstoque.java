package com.wr.estoqueapi.entities;

import java.util.UUID;

public class ProdutoEstoque {
    private UUID produtoId;
    private int quantidadeDisponivel;

    public ProdutoEstoque(UUID produtoId, int quantidadeDisponivel) {
        this.produtoId = produtoId;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public UUID getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(UUID produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
