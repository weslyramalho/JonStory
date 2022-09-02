package com.wr.lojabff.adapters.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCriacaoResponse{
    private UUID id;
    private String descricao;
    private BigDecimal preco;
}
