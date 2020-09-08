package com.example.demo.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Persona;
import com.example.demo.services.PersonaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseController<Persona, PersonaService> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/find")
    public ResponseEntity<?> findBy(@RequestParam String filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findByFilter(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+e.getMessage()+"\"}"));
        }
    }
}
