package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.Vehiculos;
import com.example.shipping.repository.VehiculosRepository;

import java.util.List;
@Service
public class VehiculosService {
    @Autowired
    private VehiculosRepository vehiculosRepository;


    public List<Vehiculos> getAllVehiculos() {
        return vehiculosRepository.findAll();
    }

    public Vehiculos getVehiculosById(Integer id) {
        return vehiculosRepository.findById(id).orElse(null);
    }

    public void addVehiculos(Vehiculos vehiculos) {
        vehiculosRepository.save(vehiculos);
    }

    public void updateVehiculos(Integer id, Vehiculos vehiculos) {
        vehiculosRepository.save(vehiculos);

    }

    public void deleteVehiculos(Integer id) {
        vehiculosRepository.deleteById(id);
    }
}
