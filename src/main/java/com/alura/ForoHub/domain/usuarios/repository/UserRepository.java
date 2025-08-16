package com.alura.ForoHub.domain.usuarios.repository;

import com.alura.ForoHub.domain.usuarios.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsuarioEntity,Integer> {
    Optional<UsuarioEntity> findByUserr(String username);
}
