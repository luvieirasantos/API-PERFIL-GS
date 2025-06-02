package com.conexaosolidaria.api_perfil.controller;

import com.conexaosolidaria.api_perfil.model.Perfil;
import com.conexaosolidaria.api_perfil.repository.PerfilRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @GetMapping
    public List<Perfil> listarPerfis() {
        return perfilRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPerfilPorId(@PathVariable Long id) {
        return perfilRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Perfil criarPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizarPerfil(@PathVariable Long id, @RequestBody Perfil perfilAtualizado) {
        return perfilRepository.findById(id)
                .map(perfil -> {
                    perfil.setNickname(perfilAtualizado.getNickname());
                    perfil.setBloodType(perfilAtualizado.getBloodType());
                    perfil.setAllergies(perfilAtualizado.getAllergies());
                    perfil.setMedicalConditions(perfilAtualizado.getMedicalConditions());
                    perfil.setContinuousMedication(perfilAtualizado.getContinuousMedication());
                    perfil.setObservations(perfilAtualizado.getObservations());
                    perfil.setAvatarUrl(perfilAtualizado.getAvatarUrl());
                    perfil.setEmergencyContactName(perfilAtualizado.getEmergencyContactName());
                    perfil.setEmergencyContactPhone(perfilAtualizado.getEmergencyContactPhone());
                    return ResponseEntity.ok(perfilRepository.save(perfil));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
