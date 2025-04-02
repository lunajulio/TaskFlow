package com.example.taskflow.controllers;


import com.example.taskflow.domain.user.DataRegisterUser;
import com.example.taskflow.domain.user.DataResponseUser;
import com.example.taskflow.domain.user.User;
import com.example.taskflow.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<DataResponseUser> registerUser(@RequestBody @Valid DataRegisterUser dataRegisterUser) {
        try {
            User user = userService.registerUser(dataRegisterUser);
            System.out.println("Usuario registrado exitosamente: " + user.getId());
            return ResponseEntity.ok(new DataResponseUser(user));
        } catch (Exception e) {
            System.err.println("Error en UserController: " + e.getMessage());
            throw e;
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}
