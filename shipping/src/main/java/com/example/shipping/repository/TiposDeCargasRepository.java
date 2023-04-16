package com.example.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shipping.model.TiposDeCargas;

public interface TiposDeCargasRepository extends JpaRepository<TiposDeCargas, Integer>{
    
}
