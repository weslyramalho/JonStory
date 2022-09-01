package com.wr.estoqueapi.controllers;

import com.wr.estoqueapi.adapters.EstoqueAdapter;
import com.wr.estoqueapi.adapters.requests.EstoqueCriarRequest;
import com.wr.estoqueapi.adapters.responses.EstoqueCriarResponse;
import com.wr.estoqueapi.entities.Estoque;
import com.wr.estoqueapi.entities.ProdutoEstoque;
import com.wr.estoqueapi.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private EstoqueAdapter estoqueAdapter;

    @PostMapping()
    public ResponseEntity<EstoqueCriarResponse> criar(@RequestBody EstoqueCriarRequest estoqueCriarRequest) throws IOException{
        Estoque novoEstoque = estoqueAdapter.paraEstoque(estoqueCriarRequest);
        Estoque criarEstoque = estoqueService.criar(novoEstoque);
        if(criarEstoque != null)
            return new ResponseEntity<>(estoqueAdapter.paraEstoqueCriarResponse(criarEstoque), HttpStatus.CREATED);
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível criar o estoque");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscar(@PathVariable UUID id){
        Estoque estoque = estoqueService.buscar(id);
        return new ResponseEntity<>(estoque, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Estoque>> buscarTodos(){
        List<Estoque> estoques = estoqueService.buscarTodos();
        return new ResponseEntity<>(estoques, HttpStatus.OK);
    }

    @GetMapping("/produtos/{produtosId}/acessivel")
    public ResponseEntity<ProdutoEstoque> buscarPorProduto(@PathVariable UUID produtoId){
        ProdutoEstoque produtoEstoque = estoqueService.porProduto(produtoId);
        return new ResponseEntity<>(produtoEstoque, HttpStatus.OK);
    }
}
