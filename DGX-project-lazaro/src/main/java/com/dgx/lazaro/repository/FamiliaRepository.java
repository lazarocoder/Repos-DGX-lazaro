package com.dgx.lazaro.repository;

import com.dgx.lazaro.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

    @Query("SELECT f FROM familia f")
    List<Familia> findAllCustom();
    List<Familia> findByNomeContainingIgnoreCase(String nome);
}






