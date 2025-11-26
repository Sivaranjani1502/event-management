package com.example.event.controller;

import com.example.event.service.EventService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EventControllerTest {

    @Test
    void testEventsPageLoads() throws Exception {
        EventService service = Mockito.mock(EventService.class);

        EventController controller = new EventController(
                service, null, null, null
        );

        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();

        mvc.perform(get("/events"))
                .andExpect(status().isOk());
    }
}
