package com.midia.scala.culto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "{cultoData}")
    public Optional<Culto> findCultoByData(@PathVariable("cultoData") Long cultoData) {
        return this.cultoService.findCultoByData(cultoData);
    }

    public void saveAll(Set<Culto> cultos) {
        this.cultoService.saveAll(cultos);
    }
}
