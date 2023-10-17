package com.br.consultPsicolog.controller;

import com.br.consultPsicolog.entity.Cliente;
import com.br.consultPsicolog.entity.MatriculaCliente;
import com.br.consultPsicolog.service.MatriculaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula-cliente")
public class MatriculaClienteController {

    private final MatriculaClienteService service;

    @Autowired
    public MatriculaClienteController(MatriculaClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaCliente> create(@RequestBody MatriculaCliente matriculaCliente) {
        MatriculaCliente matriculaClienteCreated = service.create(matriculaCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaClienteCreated);
    }

    @PatchMapping("/trancar-matricula/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchStatus(@PathVariable Long id) throws Exception {
        service.trancarMatricula(id);
    }

    @GetMapping(value = "/cliente/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('DIRETOR', 'USUARIO')") // Ajuste as permissões conforme necessário
    public List<Cliente> retornaClientesStatus(@PathVariable String status) {
        return service.retonaClientesStatus(status);
    }
}
