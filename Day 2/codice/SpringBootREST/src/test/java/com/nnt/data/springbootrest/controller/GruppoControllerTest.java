package com.nnt.data.springbootrest.controller;


import com.nnt.data.springbootrest.model.Gruppo;
import com.nnt.data.springbootrest.model.Utente;
import com.nnt.data.springbootrest.repository.GruppoRepository;
import com.nnt.data.springbootrest.repository.UtenteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class GruppoControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private GruppoRepository gruppoRepository;

    @MockBean
    private UtenteRepository utenteRepository;

    @InjectMocks
    private GruppoController gruppoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gruppoController).build();
    }

    @Test
    public void testGetGroups() throws Exception {
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(1L);
        gruppo1.setName("Gruppo 1");

        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(2L);
        gruppo2.setName("Gruppo 2");

        when(gruppoRepository.findAll()).thenReturn(Arrays.asList(gruppo1, gruppo2));

        verify(gruppoRepository).save(gruppo1);

        mockMvc.perform(MockMvcRequestBuilders.get("/groups/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddUserToGroup() throws Exception {
        Gruppo gruppo = new Gruppo();
        gruppo.setId(1L);
        gruppo.setName("Gruppo 1");

        Utente utente = new Utente();
        utente.setId(1L);
        utente.setName("Utente 1");

        when(gruppoRepository.findById(anyLong())).thenReturn(Optional.of(gruppo));
        when(utenteRepository.findById(anyLong())).thenReturn(Optional.of(utente));

        mockMvc.perform(MockMvcRequestBuilders.put("/groups/{groupId}/users/{userId}", 1L, 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateGroup() throws Exception {
        Gruppo gruppo = new Gruppo();
        gruppo.setId(1L);
        gruppo.setName("Gruppo 1");

        when(gruppoRepository.save(any(Gruppo.class))).thenReturn(gruppo);

        mockMvc.perform(MockMvcRequestBuilders.post("/groups")
                        .content("{\"name\":\"Gruppo 1\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteGroup() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/groups/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}