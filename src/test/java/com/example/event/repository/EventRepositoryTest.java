package com.example.event.repository;

import com.example.event.entity.Event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EventRepositoryTest {

    @Autowired
    private EventRepository repo;

    @Test
    void testSaveAndFind() {
        Event event = new Event();
        event.setTitle("Sample Event");
        event.setVenue("Chennai");
        event.setDate(LocalDate.now());
        event.setCapacity(100);

        repo.save(event);

        assertThat(repo.findAll()).hasSize(1);
    }
}
