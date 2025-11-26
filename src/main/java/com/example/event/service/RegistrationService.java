package com.example.event.service;

import com.example.event.entity.Registration;
import com.example.event.repository.RegistrationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository repo;

    public RegistrationService(RegistrationRepository repo) {
        this.repo = repo;
    }

    public Registration register(Long userId, Long eventId) {
        Registration r = new Registration(userId, eventId);
        return repo.save(r);
    }

    public List<Registration> getEventRegistrations(Long eventId) {
        return repo.findByEventId(eventId);
    }
}
