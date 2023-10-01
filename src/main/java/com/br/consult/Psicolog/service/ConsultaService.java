package com.br.consult.Psicolog.service;

import com.br.consult.Psicolog.entity.Cliente;
import com.br.consult.Psicolog.entity.Consulta;
import com.br.consult.Psicolog.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Consulta create(Consulta consulta) {
        return repository.save(consulta);
    }

    public List<Consulta> findAll() {
        return repository.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Cliente> buscarListaClientes(Long id){
        Query query = entityManager.createNativeQuery("select c.* from cliente_online.consulta co" +
                "  inner join cliente_online.cliente_consulta cc on co.id = cc.id_consulta" +
                "  inner join  cliente_online.cliente c on cc.id_cliente = c.id" +
                "  where co.id = " + id, "ClientesConsultasMapping");
        List<Cliente> pessoas = query.getResultList();
        return pessoas;
    }

}
