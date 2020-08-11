package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.LibroEntity;
import com.example.demo.repositories.LibroRepository;

@Service
public class LibroService {
	
	private LibroRepository repository;

	public LibroService(LibroRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public List<LibroEntity> findAll() throws Exception {
		
		try {
		
			List<LibroEntity> entities = repository.findAll();
			return entities;
		
		
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public LibroEntity findById(Long id) throws Exception {
		
		try {
		
			Optional<LibroEntity> entityOptional = repository.findById(id);
			LibroEntity entity = entityOptional.get();
		
			return entity ;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public LibroEntity save (LibroEntity newEntity) throws Exception {
		
		try {
			
			newEntity = repository.save(newEntity);
			return newEntity;		
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
	@Transactional
	public LibroEntity update (Long id, LibroEntity entity) throws Exception {
		
		try {
			
			Optional<LibroEntity> entityOptional = repository.findById(id);
			LibroEntity updateEntity = entityOptional.get();
			updateEntity = repository.save(entity);
			return updateEntity;
			
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
	@Transactional
	public boolean delete(Long id) throws Exception {
		
		try {
			
			if (repository.existsById(id)) {
				
				repository.deleteById(id);
				return true;
				
			}
			
			else {
				
				throw new Exception();
				
			}
			
		} catch (Exception e) {
			
			throw new Exception();
			
		}
		
	}
}
