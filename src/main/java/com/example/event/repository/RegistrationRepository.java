package com.example.event.repository;

import com.example.event.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    // All registrations for a user
    List<Registration> findByUserId(Long userId);

    // All registrations for a specific event
    List<Registration> findByEventId(Long eventId);
}
