package com.example.taskflow.domain.task;

import com.example.taskflow.domain.board.Board;
import com.example.taskflow.domain.user.User;
import com.example.taskflow.domain.workspace.Workspace;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime dueDate;
    private User creator;
    private Board board;

    public Task(String title, String description, Status status, Priority priority, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public User getCreator() {
        return creator;
    }

    public Board getBoard() {
        return board;
    }
}
