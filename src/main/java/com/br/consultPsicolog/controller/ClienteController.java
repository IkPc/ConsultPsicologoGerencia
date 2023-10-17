package com.br.consultPsicolog.controller;

import com.br.consultPsicolog.entity.Cliente;
import com.br.consultPsicolog.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/listar-por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscarNome(@PathVariable String nome) {
        return service.listaPorNome(nome);
    }

    @PostMapping("/listar-por-nome-email")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscarNomeOrEmail(@RequestBody Cliente dto) {
        return service.listaPorNomeOrEmail(dto);
    }

    @GetMapping("/atualiza-email/{email}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizaEmail(@PathVariable String email, @PathVariable Long id, Principal principal) {
        // Verifique se o usuário autenticado tem permissão para atualizar o email do cliente
        // Implemente a lógica para verificar as permissões do usuário autenticado.
        // Exemplo: se (temPermissaoAtualizarEmail(principal)) { service.atualizaEmailCliente(email, id); }
    }

    @GetMapping("/listar-cliente-consulta/{idConsulta}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Cliente> listarClienteConsulta(@PathVariable Long idConsulta) {
        return service.listaClienteConsulta(idConsulta);
    }

    // Adicione outros endpoints conforme necessário

}
