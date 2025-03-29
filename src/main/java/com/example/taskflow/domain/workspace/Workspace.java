package com.example.taskflow.domain.workspace;

import com.example.taskflow.domain.board.Board;
import com.example.taskflow.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class Workspace {
    private Long id;
    private String name;
    private String description;
    private User owner;
    private List<User> memberList = new ArrayList<>();
    private List<Board> boardList = new ArrayList<>();

    public Workspace(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
