package com.br.consultPsicolog.dto;

import lombok.Data;

@Data
public class CadastroCliente {

    private String nomeCliente;
    private String emailCliente;
    private Long idConsulta;

}
