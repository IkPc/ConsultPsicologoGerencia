package com.br.consult.Psicolog.service;

import com.br.consult.Psicolog.dto.HistoricoClienteDTO;
import com.br.consult.Psicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consult.Psicolog.entity.Cliente;
import com.br.consult.Psicolog.entity.MatriculaCliente;
import com.br.consult.Psicolog.repository.MatriculaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MatriculaClienteService {


    @Autowired
    MatriculaClienteRepository repository;

    public MatriculaCliente create(MatriculaCliente matriculaCliente) {
        matriculaCliente.setStatus("MATRICULADO");
        return repository.save(matriculaCliente);
    }

    public void trancarMatricula(Long matriculaClienteId) throws Exception {
        Optional<MatriculaCliente> matriculaClienteToUpdate = repository.findById(matriculaClienteId);

        if (matriculaClienteToUpdate.isPresent()) {
            if (Objects.equals(matriculaClienteToUpdate.get().getStatus(), "MATRICULADO")) {
                matriculaClienteToUpdate.ifPresent(matriculaCliente -> matriculaCliente.setStatus("TRANCADA"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível trancar com status MATRICULADO.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada.");
        }
        repository.save(matriculaClienteToUpdate.get());
    }

    public List<Cliente> retonaClientesStatus(String status) {

        return repository.retornaClientes(status);
    }

}