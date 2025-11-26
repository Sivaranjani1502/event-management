package com.example.event.controller;

import com.example.event.entity.Event;
import com.example.event.entity.User;
import com.example.event.service.EventService;
import com.example.event.service.RegistrationService;
import com.example.event.repository.UserRepository;
import com.example.event.service.EmailService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class EventController {

    private final EventService eventService;
    private final RegistrationService registrationService;
    private final UserRepository userRepo;
    private final EmailService emailService;

    public EventController(EventService eventService,
                           RegistrationService registrationService,
                           UserRepository userRepo,
                           EmailService emailService) {

        this.eventService = eventService;
        this.registrationService = registrationService;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

 // ⭐ BROWSE / SEARCH / FILTER EVENTS
    @GetMapping("/events")
    public String listEvents(@RequestParam(required = false) String keyword,
                             @RequestParam(required = false) String date,
                             @RequestParam(required = false) String registered,
                             Model model) {

        if (registered != null)
            model.addAttribute("message", "You have successfully registered!");

        // No search or filter → show all
        if ((keyword == null || keyword.isBlank()) && (date == null || date.isBlank())) {
            model.addAttribute("events", eventService.getAllEvents());
            return "events";
        }

        // Keyword search (title + venue)
        if (keyword != null && !keyword.isBlank()) {
            model.addAttribute("events", eventService.searchByKeyword(keyword));
            return "events";
        }

        // Date filter
        if (date != null && !date.isBlank()) {
            LocalDate d = LocalDate.parse(date);
            model.addAttribute("events", eventService.searchByDate(d));
            return "events";
        }

        return "events";
    }

    // EVENT DETAILS
    @GetMapping("/events/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {
        Event event = eventService.getEvent(id);
        model.addAttribute("event", event);
        return "event-details";
    }

    @PostMapping("/events/register/{id}")
    public String registerEvent(@PathVariable Long id,
                                @AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepo.findByEmail(userDetails.getUsername()).orElse(null);
        if (user == null) return "redirect:/events?error";

        // Save registration
        registrationService.register(user.getId(), id);

        // Send email confirmation
        Event event = eventService.getEvent(id);
        emailService.sendRegistrationEmail(user.getEmail(), event.getTitle());

        return "redirect:/events?registered&emailSent=true";
    }

}
