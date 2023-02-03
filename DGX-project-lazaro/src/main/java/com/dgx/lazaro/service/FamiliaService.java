package com.dgx.lazaro.service;

import com.dgx.lazaro.Enum.FaixaDeRendaEnum;
import com.dgx.lazaro.Enum.QuantidadeDependentesEnum;
import com.dgx.lazaro.dto.FamiliaDTO;
import com.dgx.lazaro.dto.PessoaDTO;
import com.dgx.lazaro.model.Familia;
import com.dgx.lazaro.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamiliaService {

    private final Integer IDADE_MAXIMA_DEPENDENTES = 18;

    @Autowired
    private FamiliaRepository familiaRepository;

    public List<FamiliaDTO> getListaOrdenada() {
        return getListaOrdenada(familiaRepository.findAll());
    }

    private List<FamiliaDTO> getListaOrdenada(List<Familia> familias) {
        return familias.stream()
                .filter(familia -> !familia.getPessoas().isEmpty())
                .map(this::calcularPontos)
                .sorted(Comparator.comparingInt(FamiliaDTO::getPontos).reversed())
                .collect(Collectors.toList());
    }

    public FamiliaDTO calcularPontos(Familia familia) {
        FamiliaDTO familiaDTO = new FamiliaDTO(familia);

        montarListaDependentes(familiaDTO);
        calcularRenda(familiaDTO);
        calcularPontosPorDependentes(familiaDTO);
        calcularPontosPorRenda(familiaDTO);

        return familiaDTO;
    }

    private void montarListaDependentes(FamiliaDTO familiaDTO) {
        familiaDTO.setDependentes(familiaDTO.getPessoas().stream()
                .filter(pessoa -> pessoa.getIdade() < IDADE_MAXIMA_DEPENDENTES)
                .collect(Collectors.toList()));
    }

    private void calcularRenda(FamiliaDTO familiaDTO) {
        familiaDTO.setRenda(familiaDTO.getPessoas().stream()
                .filter(pessoa -> pessoa.getRenda() != null && pessoa.getRenda().compareTo(BigDecimal.ZERO) == 1)
                .map(PessoaDTO::getRenda)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    private void calcularPontosPorDependentes(FamiliaDTO familiaDTO) {
        familiaDTO.setPontos(familiaDTO.getPontos() + QuantidadeDependentesEnum
                .getPorQuantidadeDependentes(familiaDTO.getDependentes().size()).getPontos());
    }

    private void calcularPontosPorRenda(FamiliaDTO familiaDTO) {
        familiaDTO.setPontos(familiaDTO.getPontos() + FaixaDeRendaEnum.getPorRenda(familiaDTO.getRenda()).getPontos());
    }
}
