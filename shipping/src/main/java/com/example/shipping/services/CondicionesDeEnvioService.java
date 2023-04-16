package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.CondicionesDeEnvio;
import com.example.shipping.repository.CondicionesDeEnvioRepository;

import java.util.List;
@Service
public class CondicionesDeEnvioService {
    @Autowired
    private CondicionesDeEnvioRepository condicionesDeEnvioRepository;


    public List<CondicionesDeEnvio> getAllCondicionesDeEnvio() {
        return condicionesDeEnvioRepository.findAll();
    }

    public CondicionesDeEnvio getCondicionesDeEnvioById(Integer id) {
        return condicionesDeEnvioRepository.findById(id).orElse(null);
    }

    public void addCondicionesDeEnvio(CondicionesDeEnvio condicionesDeEnvio) {
        condicionesDeEnvioRepository.save(condicionesDeEnvio);
    }

    public void updateCondicionesDeEnvio(Integer id, CondicionesDeEnvio condicionesDeEnvio) {
        condicionesDeEnvioRepository.save(condicionesDeEnvio);

    }

    public void deleteCondicionesDeEnvio(Integer id) {
        condicionesDeEnvioRepository.deleteById(id);
    }
}
