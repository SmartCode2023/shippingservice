package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.TiposEnvios;
import com.example.shipping.repository.TiposEnviosRepository;

import java.util.List;
@Service
public class TiposEnviosService {
    @Autowired
    private TiposEnviosRepository tiposEnviosRepository;


    public List<TiposEnvios> getAllTiposEnvios() {
        return tiposEnviosRepository.findAll();
    }

    public TiposEnvios getTiposEnviosById(Integer id) {
        return tiposEnviosRepository.findById(id).orElse(null);
    }

    public void addTiposEnvios(TiposEnvios tiposEnvios) {
        tiposEnviosRepository.save(tiposEnvios);
    }

    public void updateTiposEnvios(Integer id, TiposEnvios tiposEnvios) {
        tiposEnviosRepository.save(tiposEnvios);

    }

    public void deleteTiposEnvios(Integer id) {
        tiposEnviosRepository.deleteById(id);
    }
}
