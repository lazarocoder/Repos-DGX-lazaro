package com.dgx.lazaro.Enum;

import java.math.BigDecimal;

public enum FaixaDeRendaEnum {
    RENDA_BAIXA(BigDecimal.ZERO, new BigDecimal(900), 5),
    RENDA_MEDIA(new BigDecimal(901), new BigDecimal(1500), 3),
    RENDA_ALTA(new BigDecimal(1501), BigDecimal.valueOf(Double.MAX_VALUE), 0);

    private final BigDecimal minimo;
    private final BigDecimal maximo;
    private final int pontos;

    FaixaDeRendaEnum(BigDecimal minimo, BigDecimal maximo, int pontos){
        this.minimo = minimo;
        this.maximo = maximo;
        this.pontos = pontos;
    }

    public BigDecimal getMinimo() {
        return minimo;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public int getPontos() {
        return pontos;
    }

    public static FaixaDeRendaEnum getPorRenda(BigDecimal renda){
        for (FaixaDeRendaEnum rendaEnum : FaixaDeRendaEnum.values()) {
            if (renda.compareTo(rendaEnum.minimo) >= 0
                    && renda.compareTo(rendaEnum.maximo) < 0) {
                return rendaEnum;
            }
        }
        return RENDA_ALTA;
    }
}

