package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Persona;
import com.example.demo.repositories.PersonaRepository;

@Service
@Transactional
public class PersonaService extends BaseServiceImpl<Persona, Long> {

	@Autowired
	private PersonaRepository personaRepository;

	public PersonaService(PersonaRepository baseRepository) {
		super(baseRepository);
	}

	public List<Persona> search(String filter) throws Exception {
		try{
			List<Persona> results = personaRepository.search(filter);
			return results;
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public List<Persona> findByFilter(String filter) throws Exception {
		try{
			List<Persona> results = personaRepository.findByNombreContainingOrApellidoContaining(filter, filter);
			return results;
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
