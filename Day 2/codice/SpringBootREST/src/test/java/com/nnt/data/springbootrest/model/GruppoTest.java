package com.nnt.data.springbootrest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class GruppoTest {

    private Utente utente;
    private Gruppo gruppo;

    @BeforeEach
    public void setUp() {
        utente = new Utente();
        gruppo = new Gruppo();
    }

    @Test
    public void testAddUtente() {
        gruppo.addUtente(utente);

        assertTrue(gruppo.getUtentes().contains(utente));
        assertSame(gruppo, utente.getGruppo());
    }

    @Test
    public void testRemoveUtente() {
        List<Utente> utentes = new ArrayList<>();
        utentes.add(utente);
        gruppo.setUtentes(utentes);

        gruppo.removeUtente(utente);

        assertFalse(gruppo.getUtentes().contains(utente));
        assertNull(utente.getGruppo());
    }
}
