package com.br.consultPsicolog.dto;

import com.br.consultPsicolog.entity.Email;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ConsultasClienteDTO {

    private String nome;
    private String progresso;
    private String status;

    @ManyToOne
    @JoinColumn(name = "Email")
    private Email email;
}