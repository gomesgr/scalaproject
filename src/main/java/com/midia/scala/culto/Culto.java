package com.midia.scala.culto;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
