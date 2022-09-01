package com.wr.produtos.adapters.requests;

import java.math.BigDecimal;

public record ProdutoCreationRequest(String descricao, BigDecimal preco){
}
