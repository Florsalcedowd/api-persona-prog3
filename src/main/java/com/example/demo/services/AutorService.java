package com.example.demo.services;

import java.util.*;

import javax.transaction.Transactional;

import com.example.demo.dtos.AutorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Autor;
import com.example.demo.repositories.AutorRepository;

@Service
public class AutorService {
	
	private AutorRepository repository;

	public AutorService(AutorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public List<AutorDTO> findAll() throws Exception {

		try {

			List<Autor> entities = repository.findAll();
			List<AutorDTO> dtos = new ArrayList<>();
			ModelMapper modelMapper = new ModelMapper();

			for (Autor item : entities) {
				AutorDTO dto = (AutorDTO) modelMapper.map(item, AutorDTO.class);
				dtos.add(dto);
			}

			return dtos;
		
		
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}

	@Transactional
	public Map<String, Object> findAll(int page, int size, String sortBy, String direction) throws Exception {
		try {
			Pageable pageable;
			if (direction.equals("desc")) {
				pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy));
			} else {
				pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortBy));
			}

			Page<Autor> entityPage = repository.findAll(pageable);
			List<Autor> entities = entityPage.getContent();

			List<AutorDTO> dtos = new ArrayList<>();
			ModelMapper modelMapper = new ModelMapper();

			for (Autor item : entities) {
				AutorDTO dto = (AutorDTO) modelMapper.map(item, AutorDTO.class);
				dtos.add(dto);
			}

			Map<String, Object> response = new HashMap<>();
			response.put("payload", dtos);
			response.put("length", entityPage.getTotalElements());

			return response;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public AutorDTO findById(Long id) throws Exception {

		try {

			Optional<Autor> entityOptional = repository.findById(id);
			Autor entity = entityOptional.get();
			ModelMapper modelMapper = new ModelMapper();
			return (AutorDTO) modelMapper.map(entity,AutorDTO.class);
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}	
	
	@Transactional
	public AutorDTO save (AutorDTO autorDTO) throws Exception {

		ModelMapper modelMapper = new ModelMapper();

		try {

			Autor entity = repository.save((Autor) modelMapper.map(autorDTO, Autor.class));

			return (AutorDTO) modelMapper.map(entity, AutorDTO.class);
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
	@Transactional
	public AutorDTO update (Long id, AutorDTO autorDTO) throws Exception {

		try {

			Optional<Autor> entityOptional = repository.findById(id);
			Autor entity = entityOptional.get();

			ModelMapper modelMapper = new ModelMapper();
			Autor updateEntity = (Autor) modelMapper.map(autorDTO, Autor.class);

			updateEntity.setId(id);
			entity = repository.save(updateEntity);

			return (AutorDTO) modelMapper.map(entity, AutorDTO.class);

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
