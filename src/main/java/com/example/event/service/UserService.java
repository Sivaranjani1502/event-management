package com.example.event.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.event.entity.User;
import com.example.event.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    // Register normal user
    public User registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole("ADMIN");
        return userRepo.save(user);
    }

    // Register admin
    public User registerAdmin(String email, String password) {
        User admin = new User();
        admin.setEmail(email);
        admin.setPassword(encoder.encode(password));
        admin.setRole("ADMIN");
        return userRepo.save(admin);
    }

    public User getByEmail(String email){
        return userRepo.findByEmail(email).orElse(null);
    }
}
