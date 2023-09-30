package com.br.consult.Psicolog.controller;

import com.br.consult.Psicolog.dto.HistoricoClienteDTO;
import com.br.consult.Psicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consult.Psicolog.entity.Psicologo;
import com.br.consult.Psicolog.service.PsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @PatchMapping("/update-progresso/{matriculaId}/{consultaId}")
    @ResponseStatus(HttpStatus.OK)
    public void patchGrades(@RequestBody MatriculaClienteProgressoOnlyDTO progressoOnlyDto, @PathVariable Long matriculaId,]
        {
        service.updateProgresso(progressoOnlyDto, matriculaId);
    }

    @GetMapping("/cliente-progresso/{matriculaId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoClienteDTO ClientProgress(@PathVariable Long matriculaId) {
        return service.getHistoricoFromCliente(matriculaId);
    }
}