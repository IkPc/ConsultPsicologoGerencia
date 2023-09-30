package com.br.consult.Psicolog.repository;

import com.br.consult.Psicolog.entity.Cliente;
import com.br.consult.Psicolog.entity.MatriculaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaClienteRepository extends JpaRepository<MatriculaCliente, Long> {
    public List<MatriculaCliente> findByClienteId(Long clienteId);

    @Query(value = "SELECT (progresso FROM matricula_cliente e", nativeQuery = true)
    public Double retornaMedia();

    public List<MatriculaCliente> findByStatus(String status);
    @Query(value = "select c from MatriculaCliente m, Cliente c where c.id = m.cliente.id and " +
            " m.status = :status")
    public List<Cliente> retornaClientes(String status);
}
