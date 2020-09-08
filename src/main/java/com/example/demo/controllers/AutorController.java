package com.example.demo.controllers;

import com.example.demo.dtos.AutorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Autor;
import com.example.demo.services.AutorService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController {

	AutorService service;
	
	public AutorController(AutorService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error. Por favor intente más tarde.\"}");
			
		}
		
	}

	@GetMapping("/paged")
	public ResponseEntity<Map<String, Object>> getAllPaged(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "8") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "desc") String direction) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(service.findAll(page, size, sortBy, direction));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	@PostMapping("")
	public ResponseEntity<?> post(@RequestBody AutorDTO autorDTO) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.save(autorDTO));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Por favor chequee el ID o el BODY request, y vuelva a intentar más tarde.\"}");
						
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, autorDTO));
			
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
