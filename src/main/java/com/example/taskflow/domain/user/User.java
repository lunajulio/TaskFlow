package com.example.taskflow.domain.user;

import com.example.taskflow.domain.workspace.Workspace;
import org.hibernate.jdbc.Work;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private Long id;
    private String name;
    private String login;
    private String password;
    private List<Workspace> workspaceList = new ArrayList<>();

    public User(DataRegisterUser dataRegisterUser) {
        this.name = dataRegisterUser.name();
        this.login = dataRegisterUser.login();
        this.password = dataRegisterUser.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
