package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.Cargas;
import com.example.shipping.repository.CargasRepository;

import java.util.List;
@Service
public class CargasService {
    @Autowired
    private CargasRepository cargasRepository;


    public List<Cargas> getAllCargas() {
        return cargasRepository.findAll();
    }

    public Cargas getCargasById(Integer id) {
        return cargasRepository.findById(id).orElse(null);
    }

    public void addCargas(Cargas cargas) {
        cargasRepository.save(cargas);
    }

    public void updateCargas(Integer id, Cargas cargas) {
        cargasRepository.save(cargas);

    }

    public void deleteCargas(Integer id) {
        cargasRepository.deleteById(id);
    }
}
