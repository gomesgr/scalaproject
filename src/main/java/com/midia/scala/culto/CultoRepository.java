package com.midia.scala.culto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CultoRepository extends JpaRepository<Culto, Timestamp> {
}
