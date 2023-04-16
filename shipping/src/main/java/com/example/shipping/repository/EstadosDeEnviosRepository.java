package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.EstadosDeEnvios;

public interface EstadosDeEnviosRepository extends JpaRepository<EstadosDeEnvios, Integer>{
    
}
