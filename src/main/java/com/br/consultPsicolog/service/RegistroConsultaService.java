package com.br.consultPsicolog.service;

import com.br.consultPsicolog.dto.HistoricoClienteDTO;
import com.br.consultPsicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consultPsicolog.entity.RegistroConsulta;
import com.br.consultPsicolog.repository.RegistroConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistroConsultaService {

    @Autowired
    private RegistroConsultaRepository repository;

    public RegistroConsulta create(RegistroConsulta registroConsulta) {
        return repository.save(registroConsulta);
    }
    public void updateProgresso(MatriculaClienteProgressoOnlyDTO progressoOnlyDTO, Long matriculaClienteId, Long consultaId) {
        Optional<RegistroConsulta> registroConsulta = Optional.ofNullable(repository.
                findByMatriculaIdAndConsultaId(matriculaClienteId, consultaId));

        boolean needUpdate = false;

            repository.save(registroConsulta.get());
        }

    public HistoricoClienteDTO getHistoricoFromCliente(Long matriculaId) {
        return getHistoricoFromCliente(matriculaId);
    }
}