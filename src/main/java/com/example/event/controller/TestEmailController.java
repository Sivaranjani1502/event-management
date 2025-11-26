package com.example.event.controller;

import com.example.event.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEmailController {

    private final EmailService emailService;

    public TestEmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/test-email")
    public String testEmail() {
        String to = "your-email@gmail.com"; // <-- change to your own email
        String subject = "Test Email - Event Management System";
        String body = "If you received this email, your SMTP setup works!";

        emailService.sendSimpleMail(to, subject, body);

        return "Email sent successfully!";
    }
}
