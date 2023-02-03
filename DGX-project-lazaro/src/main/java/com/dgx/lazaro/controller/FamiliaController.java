package com.dgx.lazaro.controller;

import com.dgx.lazaro.dto.FamiliaDTO;
import com.dgx.lazaro.service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping("/rank")
    public ResponseEntity<List<FamiliaDTO>> consultarRank() {
        try {
            List<FamiliaDTO> familiasDTO = familiaService.getListaOrdenada();

            if(familiasDTO.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(familiasDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
