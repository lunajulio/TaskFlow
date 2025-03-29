package com.example.taskflow.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataRegisterUser(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
