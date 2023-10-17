package com.br.consultPsicolog.service;

import com.br.consultPsicolog.entity.Cliente;
import com.br.consultPsicolog.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listaTodos(){
        return repository.findAll();
    }

    public List<Cliente> listaPorNome(String nome){

        return repository.findByNomeContainsIgnoreCase(nome);
    }

    public List<Cliente> listaPorNomeOrEmail(Cliente dto) {
        return repository.findByNomeOrEmail(dto.getNome(), dto.getEmail());
    }

    @Transactional
    public void atualizaEmailCliente(String email, Long id){
        repository.atualizaEmailCliente(email, id);
    }

    public List<Cliente> listaClienteConsulta(Long idConsulta){
        return repository.listaClienteConsulta(idConsulta);
    }
}
