package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.EstadosDeEnvios;
import com.example.shipping.services.EstadosDeEnviosService;

import java.util.List;


@RestController
@RequestMapping("/estadosDeEnvios")
public class EstadosDeEnviosController {
    @Autowired
    private EstadosDeEnviosService estadosDeEnviosService;

    @GetMapping
    public ResponseEntity<List<EstadosDeEnvios>> getAllEstadosDeEnvios() {
        return ResponseEntity.ok(estadosDeEnviosService.getAllEstadosDeEnvios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadosDeEnvios> updateEstadosDeEnvios(@PathVariable Integer id, @RequestBody EstadosDeEnvios estadosDeEnvios) {
        if (estadosDeEnviosService.getEstadosDeEnviosById(id) != null) {
            estadosDeEnviosService.updateEstadosDeEnvios(id, estadosDeEnvios);
            return new ResponseEntity<>(estadosDeEnvios, HttpStatus.OK);
        }
        return new ResponseEntity<>(estadosDeEnvios, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstadosDeEnvios> getEstadosDeEnviosById(@PathVariable Integer id) {
        EstadosDeEnvios estadosDeEnvios = estadosDeEnviosService.getEstadosDeEnviosById(id);
        if (estadosDeEnvios != null) {
            return new ResponseEntity<>(estadosDeEnvios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadosDeEnvios> deleteEstadosDeEnviosById(@PathVariable Integer id) {
        EstadosDeEnvios estadosDeEnvios = estadosDeEnviosService.getEstadosDeEnviosById(id);
        if (estadosDeEnvios!= null) {
            estadosDeEnviosService.deleteEstadosDeEnvios(id);
            return new ResponseEntity<>(estadosDeEnvios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<EstadosDeEnvios> createEstadosDeEnvios(@RequestBody EstadosDeEnvios estadosDeEnvios) {
        estadosDeEnviosService.addEstadosDeEnvios(estadosDeEnvios);
        return new ResponseEntity<>(estadosDeEnvios, HttpStatus.CREATED);
    }
}
