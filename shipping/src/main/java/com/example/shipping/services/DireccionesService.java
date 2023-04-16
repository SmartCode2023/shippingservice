package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.Direcciones;
import com.example.shipping.repository.DireccionesRepository;

import java.util.List;
@Service
public class DireccionesService {
    @Autowired
    private DireccionesRepository direccionesRepository;


    public List<Direcciones> getAllDirecciones() {
        return direccionesRepository.findAll();
    }

    public Direcciones getDireccionesById(Integer id) {
        return direccionesRepository.findById(id).orElse(null);
    }

    public void addDirecciones(Direcciones direcciones) {
        direccionesRepository.save(direcciones);
    }

    public void updateDirecciones(Integer id, Direcciones direcciones) {
        direccionesRepository.save(direcciones);

    }

    public void deleteDirecciones(Integer id) {
        direccionesRepository.deleteById(id);
    }
}
