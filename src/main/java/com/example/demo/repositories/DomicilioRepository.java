package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.DomicilioEntity;

public interface DomicilioRepository extends JpaRepository<DomicilioEntity, Long> {

}
