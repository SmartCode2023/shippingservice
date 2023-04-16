package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.TiposVehiculos;
import com.example.shipping.services.TiposVehiculosService;

import java.util.List;


@RestController
@RequestMapping("/tiposVehiculos")
public class TiposVehiculosController {
    @Autowired
    private TiposVehiculosService tiposVehiculosService;

    @GetMapping
    public ResponseEntity<List<TiposVehiculos>> getAllTiposVehiculos() {
        return ResponseEntity.ok(tiposVehiculosService.getAllTiposVehiculos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiposVehiculos> updateTiposVehiculos(@PathVariable Integer id, @RequestBody TiposVehiculos tiposVehiculos) {
        if (tiposVehiculosService.getTiposVehiculosById(id) != null) {
            tiposVehiculosService.updateTiposVehiculos(id, tiposVehiculos);
            return new ResponseEntity<>(tiposVehiculos, HttpStatus.OK);
        }
        return new ResponseEntity<>(tiposVehiculos, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TiposVehiculos> getTiposVehiculosById(@PathVariable Integer id) {
        TiposVehiculos tiposVehiculos = tiposVehiculosService.getTiposVehiculosById(id);
        if (tiposVehiculos != null) {
            return new ResponseEntity<>(tiposVehiculos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TiposVehiculos> deleteTiposVehiculosById(@PathVariable Integer id) {
        TiposVehiculos tiposVehiculos = tiposVehiculosService.getTiposVehiculosById(id);
        if (tiposVehiculos!= null) {
            tiposVehiculosService.deleteTiposVehiculos(id);
            return new ResponseEntity<>(tiposVehiculos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<TiposVehiculos> createTiposVehiculos(@RequestBody TiposVehiculos tiposVehiculos) {
        tiposVehiculosService.addTiposVehiculos(tiposVehiculos);
        return new ResponseEntity<>(tiposVehiculos, HttpStatus.CREATED);
    }
}
