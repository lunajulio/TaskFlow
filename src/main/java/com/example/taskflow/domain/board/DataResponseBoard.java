package com.example.taskflow.domain.board;

import com.example.taskflow.domain.task.Task;

import java.util.List;

public record DataResponseBoard(
        Long id,
        String title,
        String description,
        List<Task> taskList,
        Long workspace
) {

        public DataResponseBoard(Board board) {
            this(board.getId(),
                    board.getTitle(),
                    board.getDescription(),
                    board.getTaskList(),
                    board.getWorkspace().getId());
        }
}
