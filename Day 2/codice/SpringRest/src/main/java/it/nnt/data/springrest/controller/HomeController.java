package it.nnt.data.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?> home(){
        Map<String,String> homeResp = new HashMap<>();
        homeResp.put("message","ciao");
        return new ResponseEntity<>(homeResp, HttpStatus.OK);
    }
}
