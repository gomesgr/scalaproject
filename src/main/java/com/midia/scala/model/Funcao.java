package com.midia.scala.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Table
@Data
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(columnDefinition = "VARCHAR(15)", nullable = false, unique = true)
    private String nome;

    public Funcao(UUID id, @NonNull String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Funcao(@NonNull String nome) {
        this.nome = nome;
    }

    public Funcao() {
    }
}
