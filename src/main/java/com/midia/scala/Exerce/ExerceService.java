package com.midia.scala.Exerce;

import com.midia.scala.model.Exerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExerceService {
    private final ExerceRepository exerceRepository;

    @Autowired
    public ExerceService(ExerceRepository exerceRepository) {
        this.exerceRepository = exerceRepository;
    }

    public void saveAll(Set<Exerce> exerceSet) {
        exerceRepository.saveAll(exerceSet);
    }

    public void save(Exerce exerce) {
        exerceRepository.save(exerce);
    }
}
