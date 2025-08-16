package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.usuarios.dtos.UsuarioRecord;
import com.alura.ForoHub.domain.usuarios.model.UsuarioEntity;
import com.alura.ForoHub.domain.usuarios.service.UsuarioService;
import com.alura.ForoHub.infra.security.DatosTokenRecord;
import com.alura.ForoHub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody UsuarioRecord credenciales){
        System.out.println("Usuario recibido: '" + credenciales.userr() + "'");
        System.out.println("Contraseña recibida: '" + credenciales.contrasenia() + "'");

        var token = new UsernamePasswordAuthenticationToken(credenciales.userr(), credenciales.contrasenia());
        var auth = manager.authenticate(token); // Aquí está fallando

        var usuario = (UsuarioEntity) auth.getPrincipal();

        var tokenJWT = tokenService.GenerarToken(usuario);
        return ResponseEntity.ok(new DatosTokenRecord(tokenJWT));
    }
}
