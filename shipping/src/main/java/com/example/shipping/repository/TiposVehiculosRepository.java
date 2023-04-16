package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.TiposVehiculos;

public interface TiposVehiculosRepository extends JpaRepository<TiposVehiculos, Integer>{
    
}
