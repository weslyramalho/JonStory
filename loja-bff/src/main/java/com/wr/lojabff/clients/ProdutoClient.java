package com.wr.lojabff.clients;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import com.wr.lojabff.adapters.requests.ProdutoCriacaoRequest;
import com.wr.lojabff.adapters.responses.ProdutoCriacaoResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class ProdutoClient {
    private final String BASE_URL = "http://localhost:8081/api/produtos";

    private final OkHttpClient client;
    private final Gson gson;

    public ProdutoClient() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    public ProdutoCriacaoResponse createProduct(ProdutoCriacaoRequest novoProduto) throws IOException {
        String json = gson.toJson(novoProduto);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        if(response.isSuccessful())
            return gson.fromJson(response.body().string(), ProdutoCriacaoResponse.class);

        return null;
    }

    public List<ProdutoCriacaoResponse> listProdutos() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        Response response = client.newCall(request).execute();

        Type productListType = new TypeToken<List<ProdutoCriacaoResponse>>(){}.getType();
        return gson.fromJson(response.body().string(), productListType);
    }
}
