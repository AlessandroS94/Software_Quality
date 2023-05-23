package it.nnt.data.springrest.controller;

import it.nnt.data.springrest.business.interfaces.StudentBO;
import it.nnt.data.springrest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentBO studentBO;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentBO.findAll();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        studentBO.create(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentBO.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    {

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody Student student)  {
        Student student1 = null;
        try {
            student1 = studentBO.update(id, student);
        } catch (Exception e) {
            Map<String,String> risp = new HashMap<>();
            risp.put("message",e.getMessage());
            return new ResponseEntity<>(risp,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudent(@PathVariable Long id){
        Optional<Student> student = studentBO.findStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

}
