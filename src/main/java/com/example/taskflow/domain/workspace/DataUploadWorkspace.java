package com.example.taskflow.domain.workspace;

import jakarta.validation.constraints.NotBlank;

public record DataUploadWorkspace(
        @NotBlank
        String name,
        @NotBlank
        String description
) {
}
