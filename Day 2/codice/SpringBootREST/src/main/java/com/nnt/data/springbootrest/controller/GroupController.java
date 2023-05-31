package com.nnt.data.springbootrest.controller;

import com.nnt.data.springbootrest.model.Group;
import com.nnt.data.springbootrest.model.User;
import com.nnt.data.springbootrest.repository.GroupRepository;
import com.nnt.data.springbootrest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(GroupController.class);

    @GetMapping("")
    public ResponseEntity<?> getGroups() {
        logger.info("Lista gruppi");
        return new ResponseEntity<>(groupRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{groupId}/users/{userId}")
    public ResponseEntity<?> addUserToGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        logger.info("Lista utenti");
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + groupId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        group.addUtente(user);
        userRepository.save(user);
        return new ResponseEntity(group, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        logger.info("User Creato");
        Group newGroup = groupRepository.save(group);
        return new ResponseEntity<>(newGroup,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        logger.info("User eliminato");
        groupRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}