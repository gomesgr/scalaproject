package com.midia.scala.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table
@Data
public class Exerce {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "membro_id", nullable = false)
    private UUID membroId;

    @Column(name = "funcao_id", nullable = false)
    private UUID funcaoId;

    public Exerce(UUID membroId, UUID funcaoId) {
        this.membroId = membroId;
        this.funcaoId = funcaoId;
    }

    public Exerce() {
    }

    public Exerce(UUID id) {
        this.id = id;
    }
}
