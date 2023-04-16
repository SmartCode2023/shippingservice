package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.TiposDeCargas;
import com.example.shipping.repository.TiposDeCargasRepository;

import java.util.List;
@Service
public class TiposDeCargasService {
    @Autowired
    private TiposDeCargasRepository tiposDeCargasRepository;


    public List<TiposDeCargas> getAllTiposDeCargas() {
        return tiposDeCargasRepository.findAll();
    }

    public TiposDeCargas getTiposDeCargasById(Integer id) {
        return tiposDeCargasRepository.findById(id).orElse(null);
    }

    public void addTiposDeCargas(TiposDeCargas tiposDeCargas) {
        tiposDeCargasRepository.save(tiposDeCargas);
    }

    public void updateTiposDeCargas(Integer id, TiposDeCargas tiposDeCargas) {
        tiposDeCargasRepository.save(tiposDeCargas);

    }

    public void deleteTiposDeCargas(Integer id) {
        tiposDeCargasRepository.deleteById(id);
    }
}
