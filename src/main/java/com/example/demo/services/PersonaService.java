package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.PersonaEntity;
import com.example.demo.repositories.PersonaRepository;

@Service
public class PersonaService {
	
	private PersonaRepository repository;

	public PersonaService(PersonaRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Transactional
	public List<PersonaEntity> findAll() throws Exception {
		
		try {
		
			List<PersonaEntity> entities = repository.findAll();
			return entities;
		
		
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public PersonaEntity findById(Long id) throws Exception {
		
		try {
		
			Optional<PersonaEntity> entityOptional = repository.findById(id);
			PersonaEntity entity = entityOptional.get();
		
			return entity ;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public PersonaEntity save (PersonaEntity newEntity) throws Exception {
		
		try {
			
			newEntity = repository.save(newEntity);
			return newEntity;		
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
	@Transactional
	public PersonaEntity update (Long id, PersonaEntity entity) throws Exception {
		
		try {
			
			Optional<PersonaEntity> entityOptional = repository.findById(id);
			PersonaEntity updateEntity = entityOptional.get();
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
