package com.midia.scala.Exerce;

import com.midia.scala.model.Exerce;
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
}
