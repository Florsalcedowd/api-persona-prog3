package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
	@Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filter% OR persona.apellido LIKE %:filter%", nativeQuery= true)
	List<Persona> search(@Param("filter") String filter);

	List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
	//List<Persona> findByNameContaining(String filter);
	//boolean existsByDni(int dni);
}
