package com.dgx.lazaro.dto;

import com.dgx.lazaro.model.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class PessoaDTO {

    private Long id;
    private String nome;
    private BigDecimal renda;
    private LocalDate dataNascimento;

    public PessoaDTO(Pessoa pessoa) {
        super();
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.renda = pessoa.getRenda();
       // this.dataNascimento = pessoa.getDataNascimento().toLocalDate();
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
