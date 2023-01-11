package it.corso.junitTest;

import it.corso.junitTest.business.StudentBO;
import it.corso.junitTest.model.Student;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        StudentBO studentBO = new StudentBO();
        Student student = studentBO.createStudent("Ale","Sall",29,287566);
        studentBO.toString();
        System.out.println(studentBO.calcolaAnno(student));
    }

}