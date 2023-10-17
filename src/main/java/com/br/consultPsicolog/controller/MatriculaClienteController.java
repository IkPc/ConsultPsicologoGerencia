package com.br.consultPsicolog.controller;

import com.br.consultPsicolog.entity.Cliente;
import com.br.consultPsicolog.entity.MatriculaCliente;
import com.br.consultPsicolog.service.MatriculaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula-cliente")
public class MatriculaClienteController {

    @Autowired
    MatriculaClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaCliente> create(@RequestBody MatriculaCliente matriculaCliente) {
        MatriculaCliente matriculaClienteCreated = service.create(matriculaCliente);

        return ResponseEntity.status(201).body(matriculaClienteCreated);
    }

    @PatchMapping("/trancar-matricula/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchStatus(@PathVariable Long id) throws Exception {
        service.trancarMatricula(id);
    }

    @GetMapping(value = "/cliente/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> retornaClientesStatus(@PathVariable String status) {

        return service.retonaClientesStatus(status);
    }

}