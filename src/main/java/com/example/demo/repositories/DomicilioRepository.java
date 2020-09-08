package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Domicilio;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

}
