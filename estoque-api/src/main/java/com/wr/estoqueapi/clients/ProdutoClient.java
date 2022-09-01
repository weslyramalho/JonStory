package com.wr.estoqueapi.clients;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.wr.estoqueapi.entities.Produto;
import net.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Component
public class ProdutoClient {
    final String BASE_URL = "http://localhost:8081/api/produtos"

    private final OkHttpClient client;
    private final Gson gson;

    public ProdutoClient() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    public Produto getById(UUID id) throws IOException{
        Request request = new Request.Builder()
                .url(BASE_URL + "/" id.toString())
                .build();

        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            return gson.fromJson(response.body().string(), Produto.class);
        }
        return null;
    }

    public List<Produto> getAll() throws IOException{
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        Response response = client.newCall(request).execute();

        Type produtoListType = new TypeToken<List<Produto>>(){}.getType();
        return gson.fromJson(response.body().string(), produtoListType);
    }
}
