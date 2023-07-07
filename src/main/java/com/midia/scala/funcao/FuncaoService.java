package com.midia.scala.funcao;

import com.midia.scala.model.Funcao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoService {

    private final FuncaoRepository funcaoRepository;

    @Autowired
    public FuncaoService(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public List<Funcao> findAll() {
        return funcaoRepository.findAll();
    }
}
