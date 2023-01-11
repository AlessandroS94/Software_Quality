package it.corso.junitTest.model;

public class Student {
    private String name;
    private String cognome;
    private int ageOfYear;

    private long matr;
    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ageOfYear=" + ageOfYear +
                ", matr=" + matr +
                '}';
    }

    public Student(String name, String cognome, int ageOfYear, long matr) {
        this.name = name;
        this.cognome = cognome;
        this.ageOfYear = ageOfYear;
        this.matr = matr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAgeOfYear() {
        return ageOfYear;
    }

    public void setAgeOfYear(int ageOfYear) {
        this.ageOfYear = ageOfYear;
    }

    public long getMatr() {
        return matr;
    }

    public void setMatr(long matr) {
        this.matr = matr;
    }

}
