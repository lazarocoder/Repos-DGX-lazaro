package com.dgx.lazaro.serviceTeste;


import com.dgx.lazaro.dto.FamiliaDTO;
import com.dgx.lazaro.dto.PessoaDTO;
import com.dgx.lazaro.repository.FamiliaRepository;
import com.dgx.lazaro.service.FamiliaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamiliaServiceTest {
    private FamiliaService familiaService;
    private FamiliaRepository familiaRepository;

    @BeforeEach
    public void init() {
        familiaService = new FamiliaService();
        familiaRepository = new FamiliaRepository();
        familiaService.familiaRepository = familiaRepository;
    }

    @Test
    public void testCalcularPontos() {
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setPontos(0);

        List<PessoaDTO> pessoas = new ArrayList<>();
        pessoas.add(new PessoaDTO(17, new BigDecimal(1000.00)));
        pessoas.add(new PessoaDTO(18, new BigDecimal(1000.00)));
        familiaDTO.setPessoas(pessoas);

        familiaService.calcularPontos(familiaDTO);

        assertEquals(3, familiaDTO.getPontos());
    }
}
