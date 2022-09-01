package com.wr.clientesapi.controllers;

import com.wr.clientesapi.entities.Cliente;
import com.wr.clientesapi.entities.Endereco;
import com.wr.clientesapi.services.ClienteService;
import com.wr.clientesapi.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente novoCliente){
        Cliente cliente = clienteService.criar(novoCliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PostMapping("/{clienteId}/endereco")
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco novoEndereco, @PathVariable UUID clienteId){
        novoEndereco.setClienteid(clienteId);
        Endereco endereco = enderecoService.criar(novoEndereco);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }
}
