package com.conexaosolidaria.api_perfil.controller;

import com.conexaosolidaria.api_perfil.model.Perfil;
import com.conexaosolidaria.api_perfil.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;
import com.conexaosolidaria.api_perfil.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfis")
@CrossOrigin(origins = "*") // Permite acesso do app mobile/front-end
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;


    @Autowired
    private PerfilService service;

    @GetMapping
    public List<Perfil> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPorId(@PathVariable Long id) {
        Optional<Perfil> perfil = service.buscarPorId(id);
        return perfil.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perfil> criar(@RequestBody @Valid Perfil perfil) {
        Perfil criado = service.criar(perfil);
        return ResponseEntity.ok(criado);
    }

    // Endpoint com paginação e ordenação
    @GetMapping("/paginado")
    public Page<Perfil> listarPaginado(
            @PageableDefault(size = 10, sort = "id") Pageable pageable,
            @RequestParam(required = false) String bloodType // Exemplo de filtro
    ) {
        if (bloodType != null && !bloodType.isEmpty()) {
            return perfilRepository.findByBloodType(bloodType, pageable);
        }
        return perfilRepository.findAll(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizar(@PathVariable Long id, @RequestBody @Valid Perfil perfil) {
        Optional<Perfil> existente = service.buscarPorId(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        perfil.setId(id);
        Perfil atualizado = service.atualizar(id, perfil);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Perfil> existente = service.buscarPorId(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
