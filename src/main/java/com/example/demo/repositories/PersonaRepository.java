package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
	@Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE '%:filter%' OR persona.apellido LIKE '%:filter%'", nativeQuery= true)
	List<PersonaEntity> searchByName(@Param("filter") String filter);
}
