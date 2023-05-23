package com.nnt.data.springbootrest.controller;


import com.nnt.data.springbootrest.model.Utente;
import com.nnt.data.springbootrest.repository.GruppoRepository;
import com.nnt.data.springbootrest.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    GruppoRepository gruppoRepository;
    @Autowired
    UtenteRepository utenteRepository;

    @PostMapping("/create")
    public ResponseEntity<Utente> create(@RequestBody Utente utente){
        Utente utente1 = utenteRepository.save(utente);
        return new ResponseEntity<Utente>(utente1,HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Utente>> listUtenti(){
        return new ResponseEntity<>(utenteRepository.findAll(),HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Utente> update(@RequestBody Utente utente){
        Utente utente1 = utenteRepository.save(utente);
        return new ResponseEntity<Utente>(utente1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        utenteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
