package com.midia.scala.membro;

import com.midia.scala.Exerce.Exerce;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    @OneToMany(mappedBy = "membro")
    private Set<Exerce> exerceSet;

    public Membro(String nome, String telefone, String ativo, String administrador, String usuario, String provedor) {
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.administrador = administrador;
        this.usuario = usuario;
        this.provedor = provedor;
    }

    public Membro(Long id, String nome, String telefone, String ativo, String administrador, String usuario, String provedor) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.administrador = administrador;
        this.usuario = usuario;
        this.provedor = provedor;
    }

    public Membro(Long id) {
        this.id = id;
    }
}
