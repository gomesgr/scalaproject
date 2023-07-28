package com.midia.scala.trabalha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    @GetMapping(path = "/mensal/{mes}")
    public List<Trabalha> findMensal(@PathVariable("mes") Integer mes) {
        return this.trabalhaService.findAll()
                .stream()
                .filter(trabalha ->
                        Instant.ofEpochMilli(trabalha.getCulto().getData())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime().getMonthValue() == mes
                ).toList();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "{cultoData}")
    public List<Trabalha> findByCultoData(@PathVariable("cultoData") Long cultoData) {
        List<Trabalha> trabalhadores = new ArrayList<>();
        LocalDateTime ldt = Instant.ofEpochMilli(cultoData)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        for (Trabalha trabalha: findAll()) {

            if (Objects.equals(
                    Instant.ofEpochMilli(trabalha.getCulto().getData())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime().getDayOfMonth(),
                    ldt.getDayOfMonth())) {
               trabalhadores.add(trabalha);
            }
        }
        return trabalhadores;
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
