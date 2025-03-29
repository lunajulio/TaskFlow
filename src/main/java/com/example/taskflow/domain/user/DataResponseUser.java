package com.example.taskflow.domain.user;

public record DataResponseUser(
        Long id,
        String name,
        String login
) {

    public DataResponseUser(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getLogin()
        );
    }
}
