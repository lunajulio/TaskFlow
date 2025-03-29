package com.example.taskflow.controllers;


import com.example.taskflow.domain.user.DataAuthenticationUser;
import com.example.taskflow.domain.user.User;
import com.example.taskflow.services.DatosTokenJWT;
import com.example.taskflow.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser (@RequestBody @Valid DataAuthenticationUser dataAuthenticationUser){
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataAuthenticationUser.login(),
                dataAuthenticationUser.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(JWTtoken));
    }



}
