package com.br.consult.Psicolog.controller;

import com.br.consult.Psicolog.entity.Cliente;
import com.br.consult.Psicolog.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

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
    public void atualizaEmail(@PathVariable String email, @PathVariable Long id) {

        service.atualizaEmailCliente(email, id);
    }

    @GetMapping("/listar-cliente-consulta/{idConsulta}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClienteConsulta(@PathVariable Long idConsulta) {
        return service.listaClienteConsulta(idConsulta);
    }

}