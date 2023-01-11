package it.corso.junitTest.business;

import it.corso.junitTest.model.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void secondTest() {
        StudentBO studentBO = new StudentBO();
        assertSame(StudentBO.class,studentBO.getClass());
        Student student = studentBO.createStudent("Ale","Sall",29,287566);
        assertEquals(1994,studentBO.calcolaAnno(student));
    }
}
