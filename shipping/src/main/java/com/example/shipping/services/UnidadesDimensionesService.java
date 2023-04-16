package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.UnidadesDimensiones;
import com.example.shipping.repository.UnidadesDimensionesRepository;

import java.util.List;
@Service
public class UnidadesDimensionesService {
    @Autowired
    private UnidadesDimensionesRepository unidadesDimensionesRepository;


    public List<UnidadesDimensiones> getAllUnidadesDimensiones() {
        return unidadesDimensionesRepository.findAll();
    }

    public UnidadesDimensiones getUnidadesDimensionesById(Integer id) {
        return unidadesDimensionesRepository.findById(id).orElse(null);
    }

    public void addUnidadesDimensiones(UnidadesDimensiones unidadesDimensiones) {
        unidadesDimensionesRepository.save(unidadesDimensiones);
    }

    public void updateUnidadesDimensiones(Integer id, UnidadesDimensiones unidadesDimensiones) {
        unidadesDimensionesRepository.save(unidadesDimensiones);

    }

    public void deleteUnidadesDimensiones(Integer id) {
        unidadesDimensionesRepository.deleteById(id);
    }
}
