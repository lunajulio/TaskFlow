package com.example.taskflow.services;

import com.example.taskflow.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            var algoritm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API TaskFlow")
                    .withSubject(user.getName())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("error generating token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritm = Algorithm.HMAC256(secret);
            return JWT.require(algoritm)
                    .withIssuer("API TaskFlow")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("invalid token or expired: " + exception.getMessage(), exception);
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusDays(5).toInstant(ZoneOffset.ofHours(-3));
    }
}

