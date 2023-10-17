package com.br.consultPsicolog.controller;

import com.br.consultPsicolog.dto.HistoricoClienteDTO;
import com.br.consultPsicolog.dto.MatriculaClienteProgressoOnlyDTO;
import com.br.consultPsicolog.entity.RegistroConsulta;
import com.br.consultPsicolog.service.RegistroConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro-consulta")
public class RegistroConsultaController {

    private final RegistroConsultaService service;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistroConsultaController(RegistroConsultaService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegistroConsulta> create(@RequestBody RegistroConsulta registroConsulta) {
        // Você pode codificar a senha antes de salvar no banco de dados (se necessário)
        registroConsulta.setSenha(passwordEncoder.encode(registroConsulta.getSenha()));
        RegistroConsulta entidade = service.create(registroConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
    }

    @PatchMapping("/update-progresso/{matriculaId}/{consultaId}")
    @ResponseStatus(HttpStatus.OK)
    public void patchProgress(@RequestBody MatriculaClienteProgressoOnlyDTO progressoOnlyDTO,
                              @PathVariable Long matriculaId, @PathVariable Long consultaId) {
        service.updateProgresso(progressoOnlyDTO, matriculaId, consultaId);
    }

    @GetMapping("/cliente-progresso/{matriculaId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public HistoricoClienteDTO clientProgress(@PathVariable Long matriculaId) {
        return service.getHistoricoFromCliente(matriculaId);
    }
}
