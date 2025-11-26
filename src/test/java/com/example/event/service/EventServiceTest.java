package com.example.event.service;

import com.example.event.entity.Event;
import com.example.event.repository.EventRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    private EventRepository repo;
    private EventService service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(EventRepository.class);
        service = new EventService(repo);
    }

    @Test
    void testGetAllEvents() {
        when(repo.findAll()).thenReturn(List.of(new Event(), new Event()));

        List<Event> list = service.getAllEvents();
        assertEquals(2, list.size());
    }

    @Test
    void testSaveEvent() {
        Event event = new Event();
        event.setTitle("Test Event");

        when(repo.save(event)).thenReturn(event);

        Event saved = service.saveEvent(event);
        assertEquals("Test Event", saved.getTitle());
    }

    @Test
    void testSearchByKeyword() {
        Event e1 = new Event(); e1.setTitle("Tech Summit");
        Event e2 = new Event(); e2.setVenue("Chennai Auditorium");

        when(repo.findByTitleContainingIgnoreCase("tech")).thenReturn(List.of(e1));
        when(repo.findByVenueContainingIgnoreCase("tech")).thenReturn(List.of());

        List<Event> results = service.searchByKeyword("tech");
        assertEquals(1, results.size());
    }

    @Test
    void testSearchByDate() {
        LocalDate d = LocalDate.now();
        when(repo.findByDate(d)).thenReturn(List.of(new Event()));

        List<Event> list = service.searchByDate(d);
        assertEquals(1, list.size());
    }
}
