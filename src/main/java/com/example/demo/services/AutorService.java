package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.AutorEntity;
import com.example.demo.repositories.AutorRepository;

@Service
public class AutorService {
	
	private AutorRepository repository;

	public AutorService(AutorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public List<AutorEntity> findAll() throws Exception {
		
		try {
		
			List<AutorEntity> entities = repository.findAll();
			return entities;
		
		
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public AutorEntity findById(Long id) throws Exception {
		
		try {
		
			Optional<AutorEntity> entityOptional = repository.findById(id);
			AutorEntity entity = entityOptional.get();
		
			return entity ;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public AutorEntity save (AutorEntity newEntity) throws Exception {
		
		try {
			
			newEntity = repository.save(newEntity);
			return newEntity;		
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
	@Transactional
	public AutorEntity update (Long id, AutorEntity entity) throws Exception {
		
		try {
			
			Optional<AutorEntity> entityOptional = repository.findById(id);
			AutorEntity updateEntity = entityOptional.get();
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
