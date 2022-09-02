package com.wr.pedidosapi.clients;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.wr.pedidosapi.entities.ProdutoEstoque;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class EstoqueClient {
    final String BASE_URL = "http://localhost:8080/api/estoques";

    private final Gson gson;
    private final OkHttpClient client;

    public EstoqueClient() {
        gson = new Gson();
        client = new OkHttpClient();
    }

    public ProdutoEstoque getProductStock(UUID produtoId) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/produtos/" + produtoId.toString() + "/acessivel")
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return gson.fromJson(response.body().string(), ProdutoEstoque.class);
        }

        return null;
    }


}
