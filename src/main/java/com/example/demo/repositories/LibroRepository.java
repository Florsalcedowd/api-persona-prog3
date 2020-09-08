package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
	@Query(value = "SELECT * FROM libro INNER JOIN libro_autor ON libro.id = libro_autor.libro_id INNER JOIN autor ON autor.id = libro_autor.autor_id WHERE libro.titulo LIKE %:filter% OR autor.nombre LIKE %:filter% OR autor.apellido LIKE %:filter%", nativeQuery= true)
	List<Libro> search(@Param("filter") String filter);
}
