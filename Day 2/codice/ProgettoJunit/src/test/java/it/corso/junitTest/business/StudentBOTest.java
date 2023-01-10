package it.corso.junitTest.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentBOTest {
    @Test
    void createTest() {
        StudentBO studentBO = new StudentBO();
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class,
                        () -> studentBO.createStudent("Ale","Sall",5,287566));

        assertEquals("Number age not correct",
                illegalArgumentException.getMessage());
    }
}
