package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.TiposEnvios;

public interface TiposEnviosRepository extends JpaRepository<TiposEnvios, Integer>{
    
}
