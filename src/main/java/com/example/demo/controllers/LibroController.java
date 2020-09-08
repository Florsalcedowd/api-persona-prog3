package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Libro;
import com.example.demo.services.LibroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController  extends BaseController<Libro, LibroService> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+e.getMessage()+"\"}"));
        }
    }
}
