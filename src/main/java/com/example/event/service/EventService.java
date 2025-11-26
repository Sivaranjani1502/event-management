package com.example.event.service;

import com.example.event.entity.Event;
import com.example.event.repository.EventRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    // Fetch all events
    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    // Get a single event
    public Event getEvent(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Save or update event
    public Event saveEvent(Event event) {
        return repo.save(event);
    }

    // Delete event
    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }

    // ⭐ SEARCH — Title or Venue (keyword)
    public List<Event> searchByKeyword(String keyword) {
        List<Event> byTitle = repo.findByTitleContainingIgnoreCase(keyword);
        List<Event> byVenue = repo.findByVenueContainingIgnoreCase(keyword);

        // Combine results without duplicates
        Set<Event> combined = new HashSet<>();
        combined.addAll(byTitle);
        combined.addAll(byVenue);

        return new ArrayList<>(combined);
    }

    // ⭐ FILTER — Date
    public List<Event> searchByDate(LocalDate date) {
        return repo.findByDate(date);
    }
}
