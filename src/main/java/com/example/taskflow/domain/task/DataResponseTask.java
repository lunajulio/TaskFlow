package com.example.taskflow.domain.task;


import java.time.LocalDateTime;

public record DataResponseTask(
        Long id,
        String title,
        String description,
        Status status,
        Priority priority,
        LocalDateTime dueDate,
        String creator,
        Long board
) {

    public DataResponseTask (Task task) {
        this(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate(),
                task.getCreator().getName(),
                task.getBoard().getId());
    }

}
