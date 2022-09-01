package com.wr.estoqueapi.adapters.requests;

import java.util.UUID;

public record EstoqueCriarRequest(UUID produtoId, int quantidade) {
}
