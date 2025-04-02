CREATE TABLE workspace_members (
    workspace_id BIGINT,
    user_id BIGINT,
    PRIMARY KEY (workspace_id, user_id),
    FOREIGN KEY (workspace_id) REFERENCES workspaces(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);