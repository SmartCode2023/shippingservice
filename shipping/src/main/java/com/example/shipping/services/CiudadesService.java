package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.Ciudades;
import com.example.shipping.repository.CiudadesRepository;

import java.util.List;
@Service
public class CiudadesService {
    @Autowired
    private CiudadesRepository ciudadesRepository;


    public List<Ciudades> getAllCiudades() {
        return ciudadesRepository.findAll();
    }

    public Ciudades getCiudadesById(Integer id) {
        return ciudadesRepository.findById(id).orElse(null);
    }

    public void addCiudades(Ciudades ciudades) {
        ciudadesRepository.save(ciudades);
    }

    public void updateCiudades(Integer id, Ciudades ciudades) {
        ciudadesRepository.save(ciudades);

    }

    public void deleteCiudades(Integer id) {
        ciudadesRepository.deleteById(id);
    }
}
