package com.dgx.lazaro.dto;

import com.dgx.lazaro.model.Familia;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FamiliaDTO {

    private String nome;
    private Integer pontos = 0;
    private List<PessoaDTO> pessoas;
    private List<PessoaDTO> dependentes;
    private BigDecimal renda;

    public FamiliaDTO(Familia familia) {

        super();
        this.nome = familia.getNome();
        this.pessoas = familia.getPessoas().stream()
                .map(pessoa -> new PessoaDTO(pessoa))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> getDependentes() {
        if (dependentes == null) {
            dependentes = new ArrayList<PessoaDTO>();
        }
        return dependentes;
    }

    public void setDependentes(List<PessoaDTO> dependentes) {
        this.dependentes = dependentes;
    }

    public String getNome() {
        return nome;
    }

    public List<PessoaDTO> getPessoas() {
        if (pessoas == null) {
            pessoas = new ArrayList<PessoaDTO>();
        }
        return pessoas;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }
}











