package com.example.taskflow.domain.board;

import com.example.taskflow.domain.task.Task;
import com.example.taskflow.domain.workspace.Workspace;
import org.hibernate.jdbc.Work;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Long id;
    private String title;
    private String description;
    private List<Task> taskList = new ArrayList<>();
    private Workspace workspace;

    public Board(String title, String description) {
        this.title = title;
        this.description = description;
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

    public List<Task> getTaskList() {
        return taskList;
    }

    public Workspace getWorkspace() {
        return workspace;
    }


}
