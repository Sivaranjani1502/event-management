package com.example.event.controller;

import com.example.event.entity.Event;
import com.example.event.entity.Registration;
import com.example.event.entity.User;
import com.example.event.service.EventService;
import com.example.event.service.RegistrationService;
import com.example.event.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminEventController {

    private final EventService eventService;
    private final RegistrationService registrationService;
    private final UserRepository userRepo;

    public AdminEventController(EventService eventService,
                                RegistrationService registrationService,
                                UserRepository userRepo) {

        this.eventService = eventService;
        this.registrationService = registrationService;
        this.userRepo = userRepo;
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "admin-dashboard";
    }

    // Create event page
    @GetMapping("/events/create")
    public String createForm(Model model) {
        model.addAttribute("event", new Event());
        return "create-event";
    }

    // Save event
    @PostMapping("/events/create")
    public String createEvent(Event event) {
        eventService.saveEvent(event);
        return "redirect:/admin/dashboard";
    }

    // Edit event page
    @GetMapping("/events/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEvent(id));
        return "edit-event";
    }

    // Update event
    @PostMapping("/events/update")
    public String updateEvent(Event event) {
        eventService.saveEvent(event);
        return "redirect:/admin/dashboard";
    }

    // Delete event
    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/admin/dashboard";
    }

    // ⭐ VIEW ATTENDEES WITH EMAIL
    @GetMapping("/events/{id}/attendees")
    public String attendeeList(@PathVariable Long id, Model model) {

        List<Registration> regs = registrationService.getEventRegistrations(id);

        // Convert registration objects → user email list
        List<String> emails = new ArrayList<>();

        for (Registration r : regs) {
            User user = userRepo.findById(r.getUserId()).orElse(null);
            if (user != null) {
                emails.add(user.getEmail());
            }
        }

        model.addAttribute("event", eventService.getEvent(id));
        model.addAttribute("emails", emails);

        return "attendees";
    }
}
