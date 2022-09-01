package com.wr.estoqueapi.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {
    private UUID id;
    private String descricao;
    private BigDecimal preco;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
