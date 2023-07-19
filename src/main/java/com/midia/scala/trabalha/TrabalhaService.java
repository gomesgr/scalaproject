package com.midia.scala.trabalha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TrabalhaService {

    private final TrabalhaRepository trabalhaRepository;

    @Autowired
    public TrabalhaService(TrabalhaRepository trabalhaRepository) {
        this.trabalhaRepository = trabalhaRepository;
    }

    public List<Trabalha> findAll() {
        return this.trabalhaRepository.findAll();
    }

    public void saveAll(Set<Trabalha> trabalham) {
        this.trabalhaRepository.saveAll(trabalham);
    }

    public void save(Trabalha trabalha) {
        this.trabalhaRepository.save(trabalha);
    }
}
