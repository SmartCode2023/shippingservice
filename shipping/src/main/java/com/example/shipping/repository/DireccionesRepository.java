package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.Direcciones;

public interface DireccionesRepository extends JpaRepository<Direcciones, Integer>{
    
}
