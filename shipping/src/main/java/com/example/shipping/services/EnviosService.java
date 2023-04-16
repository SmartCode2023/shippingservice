package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.Envios;
import com.example.shipping.repository.EnviosRepository;

import java.util.List;
@Service
public class EnviosService {
    @Autowired
    private EnviosRepository enviosRepository;


    public List<Envios> getAllEnvios() {
        return enviosRepository.findAll();
    }

    public Envios getEnviosById(Integer id) {
        return enviosRepository.findById(id).orElse(null);
    }

    public void addEnvios(Envios envios) {
        enviosRepository.save(envios);
    }

    public void updateEnvios(Integer id, Envios envios) {
        enviosRepository.save(envios);

    }

    public void deleteEnvios(Integer id) {
        enviosRepository.deleteById(id);
    }
}
