package com.example.event.controller;

import com.example.event.entity.User;
import com.example.event.service.UserService;
import com.example.event.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepo;

    public AuthController(UserService userService, UserRepository userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    // LOGIN PAGE
    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) String error,
                            @RequestParam(required = false) String logout,
                            @RequestParam(required = false) String registered,
                            Model model) {

        if (error != null) model.addAttribute("error", "Invalid email or password");
        if (logout != null) model.addAttribute("message", "Logged out successfully");
        if (registered != null) model.addAttribute("message", "Registration successful! Please log in.");

        return "login";
    }

    // REGISTER PAGE
    @GetMapping("/register")
    public String registerPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) model.addAttribute("error", error);
        return "register";
    }

    // REGISTER POST
    @PostMapping("/register")
    public String registerUser(@RequestParam String email,
                               @RequestParam String password,
                               Model model) {

        if (email == null || email.isBlank() || password.length() < 6) {
            model.addAttribute("error", "Enter valid email and password (min 6 chars)");
            return "register";
        }

        if (userRepo.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Email already registered");
            return "register";
        }

        userService.registerUser(email, password);

        return "redirect:/login?registered";
    }
}
