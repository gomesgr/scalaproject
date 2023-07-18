package com.midia.scala.culto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CultoService {
    private final CultoRepository cultoRepository;

    @Autowired
    public CultoService(CultoRepository cultoRepository) {
        this.cultoRepository = cultoRepository;
    }

    public List<Culto> findAll() {
        return this.cultoRepository.findAll();
    }

    public void saveAll(Set<Culto> cultos) {
        this.cultoRepository.saveAll(cultos);
    }
}
