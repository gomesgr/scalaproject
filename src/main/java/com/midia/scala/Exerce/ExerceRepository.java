package com.midia.scala.Exerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerceRepository extends JpaRepository<Exerce, UUID> {
}
