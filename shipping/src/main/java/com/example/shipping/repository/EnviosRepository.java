package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.Envios;

public interface EnviosRepository extends JpaRepository<Envios, Integer>{
    
}
