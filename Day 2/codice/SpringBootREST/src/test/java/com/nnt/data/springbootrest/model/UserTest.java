package com.nnt.data.springbootrest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testSetName() {
        String name = "John";
        user.setName(name);

        Assertions.assertEquals(name, user.getName());
    }

    @Test
    public void testSetSurname() {
        String surname = "Doe";
        user.setSurname(surname);

        Assertions.assertEquals(surname, user.getSurname());
    }

    @Test
    public void testSetData() {
        LocalDate date = LocalDate.now();
        user.setData(date);

        Assertions.assertEquals(date, user.getData());
    }

    @Test
    public void testSetGruppo() {
        Group group = new Group();
        user.setGroup(group);

        Assertions.assertEquals(group, user.getGroup());
    }
}