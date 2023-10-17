package com.br.consultPsicolog.repository;

import com.br.consultPsicolog.entity.RegistroConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroConsultaRepository extends JpaRepository<RegistroConsulta, Long> {

    RegistroConsulta findByMatriculaIdAndConsultaId(Long matriculaId, Long consultaId);

    List<RegistroConsulta> findByMatriculaId(Long matriculaId);
}