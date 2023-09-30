package com.br.consult.Psicolog.controller;

import com.br.consult.Psicolog.entity.Psicologo;
import com.br.consult.Psicolog.service.PsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psicologo")
public class PsicologoController {

    @Autowired
    PsicologoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Psicologo> create(@RequestBody Psicologo psicologo) {
        Psicologo psicologoCreated = service.create(psicologo);

        return ResponseEntity.status(201).body(psicologoCreated);
    }
}