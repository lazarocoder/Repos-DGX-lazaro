package com.dgx.lazaro.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Set;


@Entity(name = "familia")
public class Familia {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    public Set<Pessoa> pessoas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
