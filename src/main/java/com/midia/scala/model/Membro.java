package com.midia.scala.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table
@Data
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "varchar(25)")
    private String nome;

    @Column(columnDefinition = "char(11)")
    private String telefone;

    @Column(columnDefinition = "char(1) check (ativo in ('1', '0'))", nullable = false)
    private String ativo;

    @Column(columnDefinition = "char(1) check (administrador in ('1', '0'))", nullable = false)
    private String administrador;

    @Column(columnDefinition = "VARCHAR(45)")
    private String usuario;

    @Column(columnDefinition = "VARCHAR(6) CHECK (provedor IN ('LOCAL', 'GOOGLE'))")
    private String provedor;

    public Membro(String nome, String telefone, String ativo, String administrador, String usuario, String provedor) {
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.administrador = administrador;
        this.usuario = usuario;
        this.provedor = provedor;
    }

    public Membro(UUID id, String nome, String telefone, String ativo, String administrador, String usuario, String provedor) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.administrador = administrador;
        this.usuario = usuario;
        this.provedor = provedor;
    }

    public Membro() {
    }

    public Membro(UUID id) {
        this.id = id;
    }
}
