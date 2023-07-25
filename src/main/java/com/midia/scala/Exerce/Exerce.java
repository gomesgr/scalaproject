package com.midia.scala.Exerce;

import com.midia.scala.funcao.Funcao;
import com.midia.scala.membro.Membro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exerce {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column(name = "membro_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "membro_id", foreignKey = @ForeignKey(name = "fk_membro_exerce"), nullable = false)
    private Membro membro;

//    @Column(name = "funcao_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "funcao_id", foreignKey = @ForeignKey(name = "fk_funcao_exerce"), nullable = false)
    private Funcao funcao;

//    @OneToMany(mappedBy = "exerce")
//    private Set<Trabalha> trabalham;

    public Exerce(Membro membro, Funcao funcao) {
        this.membro = membro;
        this.funcao = funcao;
    }

    public Exerce(Long id) {
        this.id = id;
    }
}
