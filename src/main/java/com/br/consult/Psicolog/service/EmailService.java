package com.br.consult.Psicolog.service;

import com.br.consult.Psicolog.entity.Email;
import com.br.consult.Psicolog.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    public Email salvar(Email email) {
        return repository.save(email);
    }

    public Optional<Email> buscarPorId(Long id){
        return repository.findById(id);
    }
}