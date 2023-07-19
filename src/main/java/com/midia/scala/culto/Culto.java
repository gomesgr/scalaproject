package com.midia.scala.culto;

import com.midia.scala.trabalha.Trabalha;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Culto {
    @Id
    private Long data;

    @Nonnull
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "culto")
    private Set<Trabalha> trabalham;

    public Culto(Long data, @Nonnull String nome) {
        this.data = data;
        this.nome = nome;
    }
}
