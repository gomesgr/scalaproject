package com.midia.scala.trabalha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhaRepository extends JpaRepository<Trabalha, Long> {
}
