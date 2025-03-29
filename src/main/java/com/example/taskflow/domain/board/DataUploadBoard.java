package com.example.taskflow.domain.board;

import jakarta.validation.constraints.NotBlank;

public record DataUploadBoard(
        @NotBlank
        String title,
        @NotBlank
        String description
) {
}
