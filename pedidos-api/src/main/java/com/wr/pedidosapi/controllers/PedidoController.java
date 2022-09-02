package com.wr.pedidosapi.controllers;

import com.wr.pedidosapi.clients.EstoqueClient;
import com.wr.pedidosapi.entities.Pedido;
import com.wr.pedidosapi.producers.PedidoProducer;
import com.wr.pedidosapi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private EstoqueClient estoqueClient;

    @Autowired
    private PedidoProducer pedidoProducer;

    @PostMapping
    public ResponseEntity criar(@RequestBody Pedido novoPedido) throws IOException{
        pedidoProducer.producerCriarPedido(novoPedido);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos(){
        List<Pedido> pedidos = pedidoService.buscarTodos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
}
