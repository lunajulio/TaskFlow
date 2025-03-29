package com.example.taskflow.services;

import com.example.taskflow.domain.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

//El SecurityFilter autentica a los usuarios basándose en un token JWT,
// asegurando que solo los usuarios autenticados puedan acceder a los recursos protegidos de la aplicación.

public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = retrieveToken(request);
        if (token != null) {
            try {
                var subject = tokenService.getSubject(token);
                Optional<UserDetails> userOptional = userRepository.findByLogin(subject);
                if (userOptional.isPresent()) {
                    var userDetails = userOptional.get();
                    var authentication = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("✅ User authenticated successfully: " + userDetails.getUsername());
                    System.out.println("🔑 Roles: " + userDetails.getAuthorities());
                }
            } catch (RuntimeException ex) {
                System.err.println("Authentication error: " + ex.getMessage());
            }

        }
    }

    private String retrieveToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
