package com.midia.scala.funcao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/funcao")
public class FuncaoController {
    private final FuncaoService funcaoService;

    @Autowired
    public FuncaoController(FuncaoService funcaoService) {
        this.funcaoService = funcaoService;
    }

    @GetMapping
    public List<Funcao> findAll() {
        return funcaoService.findAll();
    }

    public Funcao findById(UUID id) {
        return funcaoService.findById(id);
    }

    @PostMapping("/test")
    public ResponseEntity<Object> testApi(@RequestBody Funcao funcao) {
        return funcaoService.testApi(funcao);
    }
}
