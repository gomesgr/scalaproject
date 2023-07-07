package com.midia.scala.membro;

import com.midia.scala.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MembroRepository extends JpaRepository<Membro, UUID> {

//    @Query("SELECT * FROM Membro WHERE telefone= ?1")
    Optional<Membro> findByTelefone(String telefone);
}
