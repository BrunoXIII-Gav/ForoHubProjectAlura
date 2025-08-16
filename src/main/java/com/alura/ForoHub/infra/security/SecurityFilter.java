package com.alura.ForoHub.infra.security;

import com.alura.ForoHub.domain.usuarios.repository.UserRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJwt = recuperarToken(request);
        if (tokenJwt!=null){
            var subject = tokenService.getSubject((String) tokenJwt);
            var usuario = userRepository.findByUserr(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.get().getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private Object recuperarToken(HttpServletRequest request) {
        var authorizaitionHeader =  request.getHeader("Authorization");
        if (authorizaitionHeader!=null){
            return authorizaitionHeader.replace("Bearer ","");

        }
        return null;
    }
}
