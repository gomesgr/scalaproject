package com.midia.scala.membro;

import lombok.*;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Membro {
    @NonNull
    private String id;
    private String nome;
    private String telefone;
    private String ativo;
    private String administrador;
}
