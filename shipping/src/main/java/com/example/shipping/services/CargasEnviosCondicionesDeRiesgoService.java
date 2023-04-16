package com.example.shipping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.CargasEnviosCondicionesDeRiesgo;
import com.example.shipping.repository.CargasEnviosCondicionesDeRiesgoRepository;

import java.util.List;
@Service
public class CargasEnviosCondicionesDeRiesgoService {
    @Autowired
    private CargasEnviosCondicionesDeRiesgoRepository cargasEnviosCondicionesDeRiesgoRepository;


    public List<CargasEnviosCondicionesDeRiesgo> getAllCargasEnviosCondicionesDeRiesgo() {
        return cargasEnviosCondicionesDeRiesgoRepository.findAll();
    }

    public CargasEnviosCondicionesDeRiesgo getCargasEnviosCondicionesDeRiesgoById(Integer id) {
        return cargasEnviosCondicionesDeRiesgoRepository.findById(id).orElse(null);
    }

    public void addCargasEnviosCondicionesDeRiesgo(CargasEnviosCondicionesDeRiesgo cargasEnviosCondicionesDeRiesgo) {
        cargasEnviosCondicionesDeRiesgoRepository.save(cargasEnviosCondicionesDeRiesgo);
    }

    public void updateCargasEnviosCondicionesDeRiesgo(Integer id, CargasEnviosCondicionesDeRiesgo cargasEnviosCondicionesDeRiesgo) {
        cargasEnviosCondicionesDeRiesgoRepository.save(cargasEnviosCondicionesDeRiesgo);

    }

    public void deleteCargasEnviosCondicionesDeRiesgo(Integer id) {
        cargasEnviosCondicionesDeRiesgoRepository.deleteById(id);
    }
}
