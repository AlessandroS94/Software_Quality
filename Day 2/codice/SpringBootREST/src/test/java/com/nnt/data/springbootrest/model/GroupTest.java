package com.nnt.data.springbootrest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class GroupTest {

    private User user;
    private Group group;

    @BeforeEach
    public void setUp() {
        user = new User();
        group = new Group();
    }

    @Test
    public void testAddUtente() {
        group.addUtente(user);

        assertTrue(group.getUsers().contains(user));
        assertSame(group, user.getGroup());
    }

    @Test
    public void testRemoveUtente() {
        List<User> users = new ArrayList<>();
        users.add(user);
        group.setUsers(users);

        group.removeUser(user);

        assertFalse(group.getUsers().contains(user));
        assertNull(user.getGroup());
    }
}
