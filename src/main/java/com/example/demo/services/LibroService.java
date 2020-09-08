package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.entities.Persona;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Libro;
import com.example.demo.repositories.LibroRepository;

@Service
@Transactional
public class LibroService extends BaseServiceImpl<Libro, Long> {

	@Autowired
	private LibroRepository libroRepository;

	public LibroService(LibroRepository baseRepository) {
		super(baseRepository);
	}

	public List<Libro> search(String filter) throws Exception {
		try{
			List<Libro> results = libroRepository.search(filter);
			return results;
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
