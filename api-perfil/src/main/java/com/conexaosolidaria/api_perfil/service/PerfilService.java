package com.conexaosolidaria.api_perfil.service;

import com.conexaosolidaria.api_perfil.model.Perfil;
import com.conexaosolidaria.api_perfil.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    public List<Perfil> listarTodos() {
        return repository.findAll();
    }

    public Optional<Perfil> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Perfil criar(Perfil perfil) {
        return repository.save(perfil);
    }

    public Perfil atualizar(Long id, Perfil perfil) {
        perfil.setId(id);
        return repository.save(perfil);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
