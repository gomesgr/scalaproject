package com.midia.scala.configs;

import com.midia.scala.Exerce.Exerce;
import com.midia.scala.Exerce.ExerceRepository;
import com.midia.scala.culto.Culto;
import com.midia.scala.culto.CultoRepository;
import com.midia.scala.funcao.Funcao;
import com.midia.scala.funcao.FuncaoRepository;
import com.midia.scala.membro.Membro;
import com.midia.scala.membro.MembroRepository;
import com.midia.scala.trabalha.Trabalha;
import com.midia.scala.trabalha.TrabalhaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class BeanConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(FuncaoRepository funcaoRepository, MembroRepository membroRepository,
                                        ExerceRepository exerceRepository, CultoRepository cultoRepository,
                                        TrabalhaRepository trabalhaRepository) {
        return args -> {
            Funcao gc = new Funcao("GC");
            Funcao som = new Funcao("Som");
            Funcao fotos = new Funcao("Fotos");
            Funcao stories = new Funcao("Stories");
            Funcao cabos = new Funcao("Cabos");
            Funcao pregador = new Funcao("Pregador");



            Membro p = new Membro(
//                    UUID.randomUUID(),
                    "Pedro",
                    "11987654567",
                    "1","0",
                    "pedrooo",
                    "LOCAL"
            );

            Membro t = new Membro(
//                    UUID.randomUUID(),
                    "Tiago",
                    "11987909567",
                    "1","0",
                    "tttaaaggg",
                    "LOCAL"
            );

            Membro v = new Membro(
//                    UUID.randomUUID(),
                    "Vinícius",
                    "11988954567",
                    "1","1",
                    "vinoccckkk",
                    "LOCAL"
            );

            Membro g = new Membro(
                    "Gabriel",
                    "11974195005",
                    "1","1",
                    "hetch",
                    "LOCAL"
            );

            Membro j = new Membro(
                    "Jamily",
                    "11987659809",
                    "1", "0",
                    "jamilyi", "LOCAL"
            );

            Membro ky = new Membro(
                    "Guilherme",
                    "1198340987",
                    "1", "0",
                    "kioshii", "LOCAL"
            );


            membroRepository.saveAll(List.of(p, v, t, g, j, ky));
            funcaoRepository.saveAll(List.of(gc, som, fotos, stories, cabos));

            Exerce ggc = new Exerce(g, gc);
            Exerce jfoto = new Exerce(j, fotos);
            Exerce vsom = new Exerce(v, som);
            Exerce tst = new Exerce(t, stories);
            Exerce pca = new Exerce(p, cabos);
            Exerce kca = new Exerce(ky, cabos);
            Exerce kso = new Exerce(ky, som);
            Exerce kgc = new Exerce(ky, gc);

            exerceRepository.saveAll(Set.of(
                    ggc,
                    new Exerce(v, gc),
                    new Exerce(p, gc),
                    new Exerce(t, fotos),
                    new Exerce(v, fotos),
                    new Exerce(p, som),
                    jfoto,
                    new Exerce(j, gc),
                    new Exerce(j, stories),
                    vsom,
                    tst,
                    pca,
                    kca,
                    kso,
                    kgc
            ));

            exerceRepository.save(new Exerce(p, fotos));

            long segunda = 1689631200000L;
            long domingo = 1689541200000L;
            long domingo2 = 1690146000000L;
            long sabado14 = 1689458400000L;
            long domingoJun = 1687725900000L;

            Culto avivaSegunda = new Culto((segunda), "Aviva Segunda");
            Culto cultoDaFamilia = new Culto((domingo), "Culto da Família");
            Culto cultoCriancas = new Culto(1689512400000L, "Culto das Crianças");
            Culto santaCeia = new Culto(sabado14, "Santa Ceia");
            Culto dd = new Culto(domingo2, "Culto da Família");
            Culto cdfJun = new Culto(domingoJun, "Culto da Família");

            cultoRepository.saveAll(Set.of(avivaSegunda, cultoDaFamilia, dd, santaCeia, cdfJun, cultoCriancas));

            Trabalha t1 = new Trabalha(ggc, avivaSegunda);
            Trabalha t2 = new Trabalha(jfoto, cultoDaFamilia);
            Trabalha t3 = new Trabalha(vsom, cdfJun);

            Trabalha t4 = new Trabalha(pca, cultoDaFamilia);
            Trabalha t5 = new Trabalha(ggc, cultoDaFamilia);
            Trabalha t6 = new Trabalha(vsom, cultoDaFamilia);
            Trabalha t7 = new Trabalha(tst, cultoDaFamilia);

            Trabalha criKyGc = new Trabalha(kgc, cultoCriancas);
            Trabalha criVSom = new Trabalha(vsom, cultoCriancas);
            Trabalha criJFot = new Trabalha(jfoto, cultoCriancas);
            Trabalha criPCab = new Trabalha(pca, cultoCriancas);
            Trabalha criTSto = new Trabalha(tst, cultoCriancas);

            trabalhaRepository.save(t1);
            trabalhaRepository.save(t2);
            trabalhaRepository.save(t3);
            trabalhaRepository.saveAll(Set.of(t4, t5, t6, t7));
            trabalhaRepository.saveAll(Set.of(criKyGc, criJFot, criPCab, criTSto, criVSom));
        };
    }
}
