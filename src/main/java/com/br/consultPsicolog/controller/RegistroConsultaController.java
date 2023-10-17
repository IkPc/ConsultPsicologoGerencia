package com.br.consultPsicolog.controller;

import com.br.consultPsicolog.dto.HistoricoClienteDTO;
import com.br.consultPsicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consultPsicolog.entity.RegistroConsulta;
import com.br.consultPsicolog.service.RegistroConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro-consulta")
public class RegistroConsultaController {

    @Autowired
    RegistroConsultaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegistroConsulta> create(@RequestBody RegistroConsulta registroConsulta) {
        RegistroConsulta entidade = service.create(registroConsulta);

        return ResponseEntity.status(201).body(entidade);
    }

    @PatchMapping("/update-notas/{matriculaId}/{disciplinaId}")
    @ResponseStatus(HttpStatus.OK)
    public void patchGrades(@RequestBody MatriculaClienteProgressoOnlyDTO progressoOnlyDTO, @PathVariable Long matriculaId,
                            @PathVariable Long consultaId) {
        service.updateProgresso(progressoOnlyDTO, matriculaId, consultaId);
    }

    @GetMapping("/cliente-progresso/{matriculaId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoClienteDTO studentGrades(@PathVariable Long matriculaId) {
        return service.getHistoricoFromCliente(matriculaId);
    }
}