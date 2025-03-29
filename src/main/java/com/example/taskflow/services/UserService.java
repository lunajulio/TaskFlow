package com.example.taskflow.services;


import com.example.taskflow.domain.user.DataRegisterUser;
import com.example.taskflow.domain.user.User;
import com.example.taskflow.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(DataRegisterUser dataRegisterUser) {
        userRepository.findByLogin(dataRegisterUser.login())
                .ifPresent(u -> {
                    throw new RuntimeException("User already exists");
                });

        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(dataRegisterUser.password());

        User user = new User(dataRegisterUser);
        user.setPassword(encryptedPassword);

        return userRepository.save(user);

    }
}
