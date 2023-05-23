package it.nnt.data.springrest.business.interfaces;

import it.nnt.data.springrest.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentBO {
    List<Student> findAll();

    void create(Student student);

    void delete(Long id);

    Student update(Long id, Student student) throws Exception;

    Optional<Student> findStudent(Long id);
}
