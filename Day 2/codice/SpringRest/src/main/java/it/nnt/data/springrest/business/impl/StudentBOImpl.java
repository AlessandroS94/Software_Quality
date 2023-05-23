package it.nnt.data.springrest.business.impl;

import it.nnt.data.springrest.business.interfaces.StudentBO;
import it.nnt.data.springrest.model.Student;
import it.nnt.data.springrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentBOImpl implements StudentBO {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
    @Override
    public Student update(Long id, Student student) throws Exception {
        studentRepository.findById(id).orElseThrow(() -> new Exception("Not exist"));
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findStudent(Long id){
        return studentRepository.findById(id);
    }
}
