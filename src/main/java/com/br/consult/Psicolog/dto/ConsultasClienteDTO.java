package com.br.consult.Psicolog.dto;

import com.br.consult.Psicolog.entity.Consulta;
import com.br.consult.Psicolog.entity.Email;
import com.br.consult.Psicolog.entity.RegistroConsulta;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Set;

@Data
public class ConsultasClienteDTO {

    private String nome;
    private String progresso;
    private String status;

    @ManyToOne
    @JoinColumn(name = "Email")
    private Email email;
}