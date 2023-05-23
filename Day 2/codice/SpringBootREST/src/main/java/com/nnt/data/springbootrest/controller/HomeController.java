package com.nnt.data.springbootrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<?> hello (){
        Map<String,String> mappa = new HashMap<>();
        mappa.put("Message","Hello");
        return new ResponseEntity<>(mappa, HttpStatus.OK);
    }
}
