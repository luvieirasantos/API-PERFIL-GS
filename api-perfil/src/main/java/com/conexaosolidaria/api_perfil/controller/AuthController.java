package com.conexaosolidaria.api_perfil.controller;

import com.conexaosolidaria.api_perfil.model.Usuario;
import com.conexaosolidaria.api_perfil.repository.UsuarioRepository;
import com.conexaosolidaria.api_perfil.util.JwtUtil;
import com.conexaosolidaria.api_perfil.service.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioDetailsService userDetailsService;

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return "Usuário cadastrado!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword())
        );
        final var userDetails = userDetailsService.loadUserByUsername(usuario.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
