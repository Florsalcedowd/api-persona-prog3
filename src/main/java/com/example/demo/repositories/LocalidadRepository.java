package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.LocalidadEntity;

public interface LocalidadRepository extends JpaRepository<LocalidadEntity, Long> {

}
