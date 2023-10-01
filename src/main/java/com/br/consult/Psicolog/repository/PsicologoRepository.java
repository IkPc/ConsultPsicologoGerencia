package com.br.consult.Psicolog.repository;

import com.br.consult.Psicolog.entity.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
}
