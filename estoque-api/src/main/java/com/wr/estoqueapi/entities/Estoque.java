package com.wr.estoqueapi.entities;

import lombok.*;

import javax.persistence.*;
import java.net.URI;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID produtoId;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private int quantidadeDisponivel;
}
