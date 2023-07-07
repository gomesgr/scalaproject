package com.midia.scala.membro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/membro")
public class MembroController {
    private final MembroService membroService;

    @Autowired
    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @GetMapping
    public List<Membro> getStudent() {
        return membroService.getStudent();
    }
}
