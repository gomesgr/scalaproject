package com.midia.scala.culto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/culto")
public class CultoController {

    private final CultoService cultoService;

    @Autowired
    public CultoController(CultoService cultoService) {
        this.cultoService = cultoService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<Culto> findAll() {
        return this.cultoService.findAll();
    }

    public void saveAll(Set<Culto> cultos) {
        this.cultoService.saveAll(cultos);
    }
}
