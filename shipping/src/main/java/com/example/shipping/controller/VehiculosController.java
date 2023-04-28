package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.TiposVehiculos;
import com.example.shipping.model.Vehiculos;
import com.example.shipping.services.TiposVehiculosService;
import com.example.shipping.services.VehiculosService;

import java.util.List;


@RestController
@RequestMapping("/shipping/vehiculos")
public class VehiculosController {
    @Autowired
    private TiposVehiculosService tiposVehiculosService;

    @Autowired
    private VehiculosService vehiculosService;
    @GetMapping
    public ResponseEntity<List<Vehiculos>> getAllVehiculos() {
        return ResponseEntity.ok(vehiculosService.getAllVehiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculos> getVehiculosById(@PathVariable Integer id) {
        Vehiculos vehiculos = vehiculosService.getVehiculosById(id);
        if (vehiculos != null) {
            return new ResponseEntity<>(vehiculos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Vehiculos> createVehiculos(@RequestBody Vehiculos vehiculos) {

        TiposVehiculos tiposVehiculos = tiposVehiculosService.getTiposVehiculosById(vehiculos.getTipoVehiculoId());
        if (tiposVehiculos!= null){
            vehiculosService.addVehiculos(vehiculos);
            return new ResponseEntity<>(vehiculos, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Vehiculos> deleteVehiculosById(@PathVariable Integer id) {
        Vehiculos vehiculos = vehiculosService.getVehiculosById(id);
        if (vehiculos!= null) {
            vehiculosService.deleteVehiculos(id);
            return new ResponseEntity<>(vehiculos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculos> updateVehiculos(@PathVariable Integer id, @RequestBody Vehiculos vehiculos) {
        if (vehiculosService.getVehiculosById(id) != null) {
            TiposVehiculos tiposVehiculos = tiposVehiculosService.getTiposVehiculosById(vehiculos.getTipoVehiculoId());

            if (tiposVehiculos!= null ){
                vehiculosService.updateVehiculos(id, vehiculos);
                return new ResponseEntity<>(vehiculos, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
