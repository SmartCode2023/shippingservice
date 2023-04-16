package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.CondicionesDeRiesgo;
import com.example.shipping.repository.CondicionesDeRiesgoRepository;

import java.util.List;
@Service
public class CondicionesDeRiesgoService {
    @Autowired
    private CondicionesDeRiesgoRepository condicionesDeRiesgoRepository;


    public List<CondicionesDeRiesgo> getAllCondicionesDeRiesgo() {
        return condicionesDeRiesgoRepository.findAll();
    }

    public CondicionesDeRiesgo getCondicionesDeRiesgoById(Integer id) {
        return condicionesDeRiesgoRepository.findById(id).orElse(null);
    }

    public void addCondicionesDeRiesgo(CondicionesDeRiesgo condicionesDeRiesgo) {
        condicionesDeRiesgoRepository.save(condicionesDeRiesgo);
    }

    public void updateCondicionesDeRiesgo(Integer id, CondicionesDeRiesgo condicionesDeRiesgo) {
        condicionesDeRiesgoRepository.save(condicionesDeRiesgo);

    }

    public void deleteCondicionesDeRiesgo(Integer id) {
        condicionesDeRiesgoRepository.deleteById(id);
    }
}
