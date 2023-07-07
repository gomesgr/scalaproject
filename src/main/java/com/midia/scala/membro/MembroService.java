package com.midia.scala.membro;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembroService {

    public List<Membro> getStudent() {
        return List.of(
                new Membro("123", "Fulano", "11987654321", "1", "0"),
                new Membro("121", "Sicrano", "11987654921", "1", "1"),
                new Membro("120", "Beltrano", "11982354321", "1", "0"));
    }
}
