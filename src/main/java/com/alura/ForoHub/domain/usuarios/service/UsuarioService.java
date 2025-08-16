package com.alura.ForoHub.domain.usuarios.service;

import com.alura.ForoHub.domain.usuarios.model.UsuarioEntity;
import com.alura.ForoHub.domain.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public UsuarioService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsuarioEntity> usuario = userRepository.findByUserr(username);

        if (usuario.isPresent()) {
            UsuarioEntity user = usuario.get();
            System.out.println("Usuario encontrado: '" + user.getUsername() + "'");
            System.out.println("Contraseña en BD: " + user.getPassword());
            System.out.println("Longitud contraseña BD: " + user.getPassword().length());
            return user;
        } else {
            System.out.println("Usuario NO encontrado");
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }

}
