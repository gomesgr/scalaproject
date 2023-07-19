package com.midia.scala.trabalha;

import com.midia.scala.culto.Culto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/trabalha")
public class TrabalhaController {

    private final TrabalhaService trabalhaService;

    @Autowired
    public TrabalhaController(TrabalhaService trabalhaService) {
        this.trabalhaService = trabalhaService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<Trabalha> findAll() {
        return this.trabalhaService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "teste")
    public Optional<Trabalha> findByCultoData(Culto culto) {
        for (Trabalha trabalha: findAll()) {
            if (Objects.equals(trabalha.getCulto().getData(), culto.getData())) {
                return Optional.of(trabalha);
            }
        }
        return Optional.empty();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(path = "/mais")
    public void saveAll(@RequestBody Set<Trabalha> trabalham) {
        this.trabalhaService.saveAll(trabalham);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public void save(@RequestBody Trabalha trabalha) {
        this.trabalhaService.save(trabalha);
    }
}
