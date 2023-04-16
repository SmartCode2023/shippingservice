package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.Cargas;

public interface CargasRepository extends JpaRepository<Cargas, Integer>{
    
}
