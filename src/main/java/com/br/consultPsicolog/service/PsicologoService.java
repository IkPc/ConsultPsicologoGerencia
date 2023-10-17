package com.br.consultPsicolog.service;

import com.br.consultPsicolog.entity.Psicologo;
import com.br.consultPsicolog.repository.PsicologoRepository;
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