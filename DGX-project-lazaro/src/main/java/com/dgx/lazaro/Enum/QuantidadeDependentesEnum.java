package com.dgx.lazaro.Enum;

public enum QuantidadeDependentesEnum {
    NENHUM(0, 0),
    ATE_2(1, 2),
    MAIS_DE_3(3, 3);

    private final Integer quantidade;
    private final Integer pontos;

    QuantidadeDependentesEnum(Integer quantidade, Integer pontos) {
        this.quantidade = quantidade;
        this.pontos = pontos;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getPontos() {
        return pontos;
    }

    public static QuantidadeDependentesEnum getPorQuantidadeDependentes(Integer quantidadeDependentes) {
        if (quantidadeDependentes >= MAIS_DE_3.quantidade) {
            return MAIS_DE_3;
        } else if (quantidadeDependentes >= ATE_2.quantidade) {
            return ATE_2;
        } else {
            return NENHUM;
        }
    }
}
