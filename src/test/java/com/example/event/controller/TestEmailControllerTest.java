package com.example.event.controller;

import com.example.event.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(TestEmailController.class)
class TestEmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @Test
    void sendTestEmail_invokesEmailService_andRedirects() throws Exception {
        mockMvc.perform(post("/test-email")
                .param("to", "a@b.com")
                .param("eventName", "HelloEvent"))
                .andExpect(status().is3xxRedirection());

        verify(emailService).sendRegistrationEmail("a@b.com", "HelloEvent");
    }
}
