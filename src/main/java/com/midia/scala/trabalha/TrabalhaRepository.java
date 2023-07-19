package com.midia.scala.trabalha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TrabalhaRepository extends JpaRepository<Trabalha, Timestamp> {
}
