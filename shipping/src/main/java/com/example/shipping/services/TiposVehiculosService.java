package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.TiposVehiculos;
import com.example.shipping.repository.TiposVehiculosRepository;

import java.util.List;
@Service
public class TiposVehiculosService {
    @Autowired
    private TiposVehiculosRepository tiposVehiculosRepository;


    public List<TiposVehiculos> getAllTiposVehiculos() {
        return tiposVehiculosRepository.findAll();
    }

    public TiposVehiculos getTiposVehiculosById(Integer id) {
        return tiposVehiculosRepository.findById(id).orElse(null);
    }

    public void addTiposVehiculos(TiposVehiculos tiposVehiculos) {
        tiposVehiculosRepository.save(tiposVehiculos);
    }

    public void updateTiposVehiculos(Integer id, TiposVehiculos tiposVehiculos) {
        tiposVehiculosRepository.save(tiposVehiculos);

    }

    public void deleteTiposVehiculos(Integer id) {
        tiposVehiculosRepository.deleteById(id);
    }
}
