package com.midia.scala.trabalha;

import com.midia.scala.Exerce.Exerce;
import com.midia.scala.culto.Culto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@Data
public class Trabalha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exerce_id", foreignKey = @ForeignKey(name = "fk_exerce_trabalha"), nullable = false)
    private Exerce exerce;

    @ManyToOne
    @JoinColumn(name = "culto_data", foreignKey = @ForeignKey(name = "fk_culto_trabalha"), nullable = false)
    private Culto culto;

    public Trabalha(Exerce exerce, Culto culto) {
        this.exerce = exerce;
        this.culto = culto;
    }
}
