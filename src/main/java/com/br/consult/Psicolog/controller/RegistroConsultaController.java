package com.br.consult.Psicolog.controller;

import com.br.consult.Psicolog.dto.HistoricoClienteDTO;
import com.br.consult.Psicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consult.Psicolog.entity.Psicologo;
import com.br.consult.Psicolog.entity.RegistroConsulta;
import com.br.consult.Psicolog.service.PsicologoService;
import com.br.consult.Psicolog.service.RegistroConsultaService;
import com.br.consult.Psicolog.dto.MatriculaClienteProgressoOnlyDTO;
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