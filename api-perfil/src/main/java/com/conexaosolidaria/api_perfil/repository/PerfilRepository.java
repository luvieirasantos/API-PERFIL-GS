package com.conexaosolidaria.api_perfil.repository;

import com.conexaosolidaria.api_perfil.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Page<Perfil> findByBloodType(String bloodType, Pageable pageable);

}
