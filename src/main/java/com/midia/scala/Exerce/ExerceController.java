package com.midia.scala.Exerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
public class ExerceController {
    private final ExerceService exerceService;

    @Autowired
    public ExerceController(ExerceService exerceService) {
        this.exerceService = exerceService;
    }

    public void saveAll(Set<Exerce> exerceSet) {
        exerceService.saveAll(exerceSet);
    }

    public void save(Exerce exerce) { exerceService.save(exerce); }
}
