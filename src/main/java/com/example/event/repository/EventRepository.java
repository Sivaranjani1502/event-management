package com.example.event.repository;

import com.example.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByTitleContainingIgnoreCase(String title);
    // Search by venue (case-insensitive)
    List<Event> findByVenueContainingIgnoreCase(String venue);

    // Search by date
    List<Event> findByDate(LocalDate date);
}
