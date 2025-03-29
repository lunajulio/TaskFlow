package com.example.taskflow.domain.workspace;

import com.example.taskflow.domain.board.Board;
import com.example.taskflow.domain.user.User;

import java.util.List;

public record DataResponseWorkspace(
        Long id,
        String name,
        String description,
        User owner,
        List<User> memberList,
        List<Board> boardList
) {
}
