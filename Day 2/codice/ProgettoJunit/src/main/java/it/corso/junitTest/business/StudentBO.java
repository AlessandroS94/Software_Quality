package it.corso.junitTest.business;

import it.corso.junitTest.model.Student;

public class StudentBO {
    public StudentBO() {
    }

    public Student createStudent(String name, String cognome, int age, long matr) {
        Student student = new Student();
        student.setName(name);
        student.setCognome(cognome);
        student.setAgeOfYear(age);
        student.setMatr(matr);
        if (age < 10){
            throw new IllegalArgumentException("Number age not correct");
        }
        return student;
    }

    public int calcolaAnno(Student student) {
        return (2023 - (int) student.getAgeOfYear());
    }




}
