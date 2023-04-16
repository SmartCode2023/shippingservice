package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.CondicionesDeEnvio;

public interface CondicionesDeEnvioRepository extends JpaRepository<CondicionesDeEnvio, Integer>{
    
}
