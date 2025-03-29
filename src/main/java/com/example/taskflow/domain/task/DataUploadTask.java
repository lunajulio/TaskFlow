package com.example.taskflow.domain.task;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUploadTask(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        @Valid
        Status status,
        @NotNull
        @Valid
        Priority priority,
        @NotNull
        LocalDateTime dueDate
) {
}
