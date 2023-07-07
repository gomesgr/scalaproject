package com.midia.scala.funcao;

import com.midia.scala.model.Funcao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FuncaoController {
    private final FuncaoService funcaoService;

    @Autowired
    public FuncaoController(FuncaoService funcaoService) {
        this.funcaoService = funcaoService;
    }

    public List<Funcao> findAll() {
        return funcaoService.findAll();
    }
}
