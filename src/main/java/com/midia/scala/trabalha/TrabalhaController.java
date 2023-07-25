package com.midia.scala.trabalha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

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
    @GetMapping(path = "/mensal/{cultoData}")
    public List<Trabalha> findMensal(@PathVariable("cultoData") Long cultoData) {
        LocalDateTime ldt = Instant.ofEpochMilli(cultoData)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return this.trabalhaService.findAll()
                .stream()
                .filter(trabalha ->
                        Instant.ofEpochMilli(trabalha.getCulto().getData())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime().getMonthValue() == ldt.getMonthValue()
                ).toList();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "{cultoData}")
    public Optional<Trabalha> findByCultoData(@PathVariable("cultoData") Long cultoData) {
        for (Trabalha trabalha: findAll()) {
            if (Objects.equals(trabalha.getCulto().getData(), cultoData)) {
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
