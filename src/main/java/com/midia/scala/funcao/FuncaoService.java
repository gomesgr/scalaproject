package com.midia.scala.funcao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncaoService {

    private final FuncaoRepository funcaoRepository;

    @Autowired
    public FuncaoService(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public List<Funcao> findAll() {
        return this.funcaoRepository.findAll();
    }

    public Funcao findById(UUID id) {
        return this.funcaoRepository.findById(id).orElse(new Funcao());
    }

    public ResponseEntity<Object> testApi(Funcao funcao) {
        if (funcao.getNome().equals("Pregador")) {
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("NOT CREATED (USED)", HttpStatus.IM_USED);
    }
}
