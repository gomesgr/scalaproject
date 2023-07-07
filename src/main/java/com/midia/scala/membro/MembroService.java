package com.midia.scala.membro;


import com.midia.scala.model.Membro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembroService {
    private final MembroRepository membroRepository;

    @Autowired
    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    public List<Membro> getMembros() {
        return membroRepository.findAll();
    }

    public void save(Membro membro) {
        membroRepository.save(membro);
    }

    public Membro getMembroByTelefone(String telefone) {
        return membroRepository.findByTelefone(telefone)
                .orElse(new Membro());
    }
}
