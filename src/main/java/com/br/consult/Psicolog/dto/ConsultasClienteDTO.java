package com.br.consult.Psicolog.dto;

import com.br.consult.Psicolog.entity.Consulta;
import com.br.consult.Psicolog.entity.RegistroConsulta;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ConsultasClienteDTO {

    private String nome;
    private Double progresso;
    private String status;
}