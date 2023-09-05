package com.br.consult.Psicolog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public class Cliente {

    @Repository
    public interface ClienteRepository extends JpaRepository<Cliente, Long>

        List<Cliente> findByNomeContainsIgnoreCase();

        List<Cliente> findByNomeOrPsicologo(String nome, String psicologo);
}
