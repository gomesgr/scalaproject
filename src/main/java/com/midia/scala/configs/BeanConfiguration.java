package com.midia.scala.configs;

import com.midia.scala.Exerce.Exerce;
import com.midia.scala.Exerce.ExerceRepository;
import com.midia.scala.funcao.Funcao;
import com.midia.scala.funcao.FuncaoRepository;
import com.midia.scala.membro.Membro;
import com.midia.scala.membro.MembroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class BeanConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(FuncaoRepository funcaoRepository, MembroRepository membroRepository, ExerceRepository exerceRepository) {
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


            membroRepository.saveAll(List.of(p, v, t, g));
            funcaoRepository.saveAll(List.of(gc, som, fotos, stories, cabos));

            exerceRepository.saveAll(Set.of(
                    new Exerce(g, gc),
                    new Exerce(v, gc),
                    new Exerce(p, gc),
                    new Exerce(t, fotos),
                    new Exerce(v, som),
                    new Exerce(v, fotos),
                    new Exerce(p, som)
            ));

            exerceRepository.save(new Exerce(p, fotos));
        };
    }
}
