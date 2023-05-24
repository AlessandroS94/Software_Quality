package com.nnt.data.springbootrest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UtenteTest {
    private Utente utente;

    @BeforeEach
    public void setUp() {
        utente = new Utente();
    }

    @Test
    public void testSetName() {
        String name = "John";
        utente.setName(name);

        Assertions.assertEquals(name, utente.getName());
    }

    @Test
    public void testSetSurname() {
        String surname = "Doe";
        utente.setSurname(surname);

        Assertions.assertEquals(surname, utente.getSurname());
    }

    @Test
    public void testSetData() {
        LocalDate date = LocalDate.now();
        utente.setData(date);

        Assertions.assertEquals(date, utente.getData());
    }

    @Test
    public void testSetGruppo() {
        Gruppo gruppo = new Gruppo();
        utente.setGruppo(gruppo);

        Assertions.assertEquals(gruppo, utente.getGruppo());
    }
}