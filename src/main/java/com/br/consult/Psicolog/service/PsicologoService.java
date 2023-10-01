package com.br.consult.Psicolog.service;

import com.br.consult.Psicolog.entity.Psicologo;
import com.br.consult.Psicolog.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsicologoService {

    @Autowired
    PsicologoRepository repository;

    public Psicologo create(Psicologo psicologo) {
        return repository.save(psicologo);
    }
}