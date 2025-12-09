package com.example.event.controller;

import com.example.event.service.UserService;
import com.example.event.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepo;

    @Test
    void whenRegisterWithNewEmail_redirectsToLogin() throws Exception {
        // assume userRepo.findByEmail returns empty (not present)
        when(userRepo.findByEmail("new@ex.com")).thenReturn(java.util.Optional.empty());

        mockMvc.perform(post("/register")
                .param("email", "new@ex.com")
                .param("password", "password123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("/login**"));

        verify(userService, times(1)).registerUser(anyString(), anyString());
    }

    @Test
    void whenRegisterExistingEmail_returnsRegisterView() throws Exception {
        // user exists
        when(userRepo.findByEmail("exists@ex.com")).thenReturn(java.util.Optional.ofNullable(new com.example.event.entity.User()));

        mockMvc.perform(post("/register")
                .param("email", "exists@ex.com")
                .param("password", "pass"))
                .andExpect(status().isOk())
                .andExpect(view().name("register")); // adjust view name if different

        verify(userService, never()).registerUser(anyString(), anyString());
    }
}
