package com.br.consult.Psicolog.dto;

import com.br.consult.Psicolog.entity.Consulta;
import lombok.Data;

import java.util.List;

@Data
public class HistoricoClienteDTO {

    private String nomeCliente;
    private Consulta Consulta;
    private List<ConsultasClienteDTO> ConsultasClienteDTO;
}