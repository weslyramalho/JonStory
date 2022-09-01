package com.wr.estoqueapi.adapters.responses;

import java.util.UUID;

public record EstoqueCriarResponse(UUID id UUID produtoId, int quantidade, int quantidadeDisponivel) {
}
