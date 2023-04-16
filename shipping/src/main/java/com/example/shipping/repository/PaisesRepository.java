package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.Paises;

public interface PaisesRepository extends JpaRepository<Paises, Integer>{
    
}
