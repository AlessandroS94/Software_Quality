package com.nnt.data.springbootrest.controller;


import com.nnt.data.springbootrest.model.User;
import com.nnt.data.springbootrest.repository.GroupRepository;
import com.nnt.data.springbootrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User user){
        User user1 = userRepository.save(user);
        return new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity<List<User>> listUtenti(){
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<User> update(@RequestBody User user){
        User user1 = userRepository.save(user);
        return new ResponseEntity<User>(user1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
