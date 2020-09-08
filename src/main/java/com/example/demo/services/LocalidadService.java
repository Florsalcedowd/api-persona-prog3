package com.example.demo.services;

import com.example.demo.entities.Localidad;
import com.example.demo.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LocalidadService extends BaseServiceImpl<Localidad, Long> {
    public LocalidadService(LocalidadRepository baseRepository) {
        super(baseRepository);
    }
}
