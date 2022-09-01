package com.wr.estoqueapi.adapters.responses;

import lombok.Builder;

import java.util.UUID;
@Builder
public record EstoqueCriarResponse(UUID id, UUID produtoId, int quantidade, int quantidadeDisponivel) {
}
