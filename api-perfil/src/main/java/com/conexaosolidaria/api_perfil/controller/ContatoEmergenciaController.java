package com.conexaosolidaria.api_perfil.controller;

import com.conexaosolidaria.api_perfil.model.ContatoEmergencia;
import com.conexaosolidaria.api_perfil.repository.ContatoEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos-emergencia")
public class ContatoEmergenciaController {

    @Autowired
    private ContatoEmergenciaRepository repository;

    @GetMapping
    public List<ContatoEmergencia> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ContatoEmergencia criar(@RequestBody ContatoEmergencia contato) {
        return repository.save(contato);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
