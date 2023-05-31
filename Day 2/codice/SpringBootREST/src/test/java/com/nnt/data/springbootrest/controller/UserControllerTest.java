package com.nnt.data.springbootrest.controller;


import com.nnt.data.springbootrest.model.User;
import com.nnt.data.springbootrest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Alex");
        user.setSurname("Doe");

        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content("{\"name\":\"John\",\"surname\":\"Doe\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testListUtenti() throws Exception {
        List<User> utenti = new ArrayList<>();
        User userA = new User();
        userA.setId(1L);
        userA.setName("Alessandro");
        userA.setSurname("Sallese");
        User userB = new User();
        userB.setId(2L); // Different id for userB
        userB.setName("Alessandro");
        userB.setSurname("Sallese");
        utenti.add(userA);
        utenti.add(userB);

        when(userRepository.findAll()).thenReturn(utenti);

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUtente() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setSurname("Doe");

        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.put("/users")
                        .content("{\"id\":1,\"name\":\"John\",\"surname\":\"Doe\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUtente() throws Exception {
        doNothing().when(userRepository).deleteById(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}