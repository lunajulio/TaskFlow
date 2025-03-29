package com.example.taskflow.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataAuthenticationUser(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
