package com.wr.clientesapi.services;

import com.wr.clientesapi.entities.Endereco;
import com.wr.clientesapi.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
}
