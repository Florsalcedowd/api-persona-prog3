package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

}
