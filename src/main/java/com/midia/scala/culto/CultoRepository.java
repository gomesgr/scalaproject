package com.midia.scala.culto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultoRepository extends JpaRepository<Culto, Long> {
}
