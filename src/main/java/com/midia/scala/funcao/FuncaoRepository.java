package com.midia.scala.funcao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, UUID> {
}
