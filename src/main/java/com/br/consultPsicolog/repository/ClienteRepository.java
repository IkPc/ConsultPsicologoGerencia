package com.br.consultPsicolog.repository;

import com.br.consultPsicolog.entity.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContainsIgnoreCase(String nome);

    List<Cliente> findByNomeOrEmail(String nome, String Email);

    @Modifying
    @Query("update Cliente a set a.email = ?1 where a.id = ?2")
    void atualizaEmailCliente(String email, Long id);

    @Query(value = "select " +
            "    a.* " +
            "    from " +
            "    consult_Psicolog.cliente c " +
            "    inner join matricula_cliente ma on " +
            "    ma.id = c.id " +
            "    inner join consulta co on " +
            "    co.id = ma.consulta_id " +
            "            where " +
            "    co.id = ?1", nativeQuery = true)
    List<Cliente> listaClienteConsulta(Long idConsulta);


}