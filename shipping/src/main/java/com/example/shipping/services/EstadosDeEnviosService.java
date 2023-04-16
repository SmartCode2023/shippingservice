package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.EstadosDeEnvios;
import com.example.shipping.repository.EstadosDeEnviosRepository;

import java.util.List;
@Service
public class EstadosDeEnviosService {
    @Autowired
    private EstadosDeEnviosRepository estadosDeEnviosRepository;


    public List<EstadosDeEnvios> getAllEstadosDeEnvios() {
        return estadosDeEnviosRepository.findAll();
    }

    public EstadosDeEnvios getEstadosDeEnviosById(Integer id) {
        return estadosDeEnviosRepository.findById(id).orElse(null);
    }

    public void addEstadosDeEnvios(EstadosDeEnvios estadoDeEnvios) {
        estadosDeEnviosRepository.save(estadoDeEnvios);
    }

    public void updateEstadosDeEnvios(Integer id, EstadosDeEnvios estadoDeEnvios) {
        estadosDeEnviosRepository.save(estadoDeEnvios);

    }

    public void deleteEstadosDeEnvios(Integer id) {
        estadosDeEnviosRepository.deleteById(id);
    }
}
