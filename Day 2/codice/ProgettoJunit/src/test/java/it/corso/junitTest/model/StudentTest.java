package it.corso.junitTest.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StudentTest {
    @Test
    void checkModel(){
        String nome = "Alessandro";
        String cognome = "Sallese";
        int ageOfYear = 29;
        long matr = 287566;
        Student student = new Student(nome,cognome,ageOfYear,matr);
        Student student2 = new Student(nome,cognome,ageOfYear,matr);
        assertEquals(nome, student.getName());
        assertEquals(cognome, student.getCognome());

    }

}
