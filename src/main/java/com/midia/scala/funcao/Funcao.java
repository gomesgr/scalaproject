package com.midia.scala.funcao;

import com.midia.scala.Exerce.Exerce;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Entity
@Table
@Data
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Nonnull
    @Column(columnDefinition = "VARCHAR(15)", nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "funcao")
    private Set<Exerce> exerceSet;

    public Funcao(Long id, @NonNull String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Funcao(@NonNull String nome) {
        this.nome = nome;
    }

    public Funcao() {
    }
}
