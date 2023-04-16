package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.Paises;
import com.example.shipping.repository.PaisesRepository;

import java.util.List;
@Service
public class PaisesService {
    @Autowired
    private PaisesRepository paisesRepository;


    public List<Paises> getAllPaises() {
        return paisesRepository.findAll();
    }

    public Paises getPaisesById(Integer id) {
        return paisesRepository.findById(id).orElse(null);
    }

    public void addPaises(Paises paises) {
        paisesRepository.save(paises);
    }

    public void updatePaises(Integer id, Paises paises) {
        paisesRepository.save(paises);

    }

    public void deletePaises(Integer id) {
        paisesRepository.deleteById(id);
    }
}
