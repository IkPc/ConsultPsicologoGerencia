package com.br.consult.Psicolog.service;

import com.br.consult.Psicolog.dto.ConsultasClienteDTO;
import com.br.consult.Psicolog.dto.HistoricoClienteDTO;
import com.br.consult.Psicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consult.Psicolog.entity.MatriculaCliente;
import com.br.consult.Psicolog.entity.RegistroConsulta;
import com.br.consult.Psicolog.repository.RegistroConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

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