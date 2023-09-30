package com.br.consult.Psicolog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegistroConsulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="matricula_id")
    private MatriculaCliente matricula;

    @ManyToOne
    @JoinColumn(name="consulta_id")
    private Consulta consulta;

    private String status;

}