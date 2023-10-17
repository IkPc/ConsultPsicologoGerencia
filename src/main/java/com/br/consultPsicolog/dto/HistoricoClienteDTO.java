package com.br.consultPsicolog.dto;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoClienteDTO {

    private String nomeCliente;
    private com.br.consultPsicolog.entity.Consulta Consulta;
    private List<ConsultasClienteDTO> ConsultasClienteDTO;
}