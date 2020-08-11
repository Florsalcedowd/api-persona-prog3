package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.AutorEntity;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
	@Query(value = "SELECT * FROM autor WHERE autor.nombre LIKE '%:filter%' OR autor.apellido LIKE '%:filter%'", nativeQuery= true)
	List<AutorEntity> searchByName(@Param("filter") String filter);
}
