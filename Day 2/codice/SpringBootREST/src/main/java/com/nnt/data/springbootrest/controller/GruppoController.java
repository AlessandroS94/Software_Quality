package com.nnt.data.springbootrest.controller;

import com.nnt.data.springbootrest.model.Gruppo;
import com.nnt.data.springbootrest.model.Utente;
import com.nnt.data.springbootrest.repository.GruppoRepository;
import com.nnt.data.springbootrest.repository.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GruppoController {

    @Autowired
    private GruppoRepository groupRepository;

    @Autowired
    private UtenteRepository userRepository;

    Logger logger = LoggerFactory.getLogger(GruppoController.class);

    @GetMapping("/")
    public ResponseEntity<?> getGroups() {
        logger.info("Lista gruppi");
        return new ResponseEntity<>(groupRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{groupId}/users/{userId}")
    public ResponseEntity<?> addUserToGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        logger.info("Lista utenti");
        Gruppo group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + groupId));
        Utente user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        group.addUtente(user);
        userRepository.save(user);
        return new ResponseEntity(group, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Gruppo> createGroup(@RequestBody Gruppo group) {
        logger.info("Utente Creato");
        Gruppo newGroup = groupRepository.save(group);
        return ResponseEntity.ok(newGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        logger.info("Utente eliminato");
        groupRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}