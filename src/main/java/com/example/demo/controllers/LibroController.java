package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LibroEntity;
import com.example.demo.services.LibroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController {

	LibroService service;
	
	public LibroController(LibroService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error. Por favor intente más tarde.\"}");
			
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error. Por favor intente más tarde.\"}");
			
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> post(@RequestBody LibroEntity entity) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Por favor chequee el ID o el BODY request, y vuelva a intentar más tarde.\"}");
						
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody LibroEntity entity) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Por favor chequee el ID o el BODY request, y vuelva a intentar más tarde.\"}");
						
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Por favor chequee el ID o el BODY request, y vuelva a intentar más tarde.\"}");
			
		}
	}


}
