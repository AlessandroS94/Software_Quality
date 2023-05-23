package com.nnt.data.springbootrest.controller;

import com.nnt.data.springbootrest.model.Utente;
import com.nnt.data.springbootrest.repository.UtenteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UtenteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UtenteRepository utenteRepository;

    @InjectMocks
    private UtenteController utenteController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(utenteController).build();
    }

    @Test
    public void testCreateUtente() throws Exception {
        Utente utente = new Utente();
        utente.setId(1L);
        utente.setName("John");
        utente.setSurname("Doe");

        when(utenteRepository.save(any(Utente.class))).thenReturn(utente);

        mockMvc.perform(MockMvcRequestBuilders.post("/utente/create")
                        .content("{\"nome\":\"John\",\"cognome\":\"Doe\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


    @Test
    public void testUpdateUtente() throws Exception {
        Utente utente = new Utente();
        utente.setId(1L);
        utente.setName("John");
        utente.setSurname("Doe");

        when(utenteRepository.save(any(Utente.class))).thenReturn(utente);

        mockMvc.perform(MockMvcRequestBuilders.post("/utente/update")
                        .content("{\"id\":1,\"nome\":\"John\",\"cognome\":\"Doe\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUtente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/utente/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}
