package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.Vehiculos;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Integer>{
    
}
