package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.TiposDeCargas;
import com.example.shipping.services.TiposDeCargasService;

import java.util.List;


@RestController
@RequestMapping("/tiposDeCargas")
public class TiposDeCargasController {
    @Autowired
    private TiposDeCargasService tiposDeCargasService;

    @GetMapping
    public ResponseEntity<List<TiposDeCargas>> getAllTiposDeCargas() {
        return ResponseEntity.ok(tiposDeCargasService.getAllTiposDeCargas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiposDeCargas> updateTiposDeCargas(@PathVariable Integer id, @RequestBody TiposDeCargas tiposDeCargas) {
        if (tiposDeCargasService.getTiposDeCargasById(id) != null) {
            tiposDeCargasService.updateTiposDeCargas(id, tiposDeCargas);
            return new ResponseEntity<>(tiposDeCargas, HttpStatus.OK);
        }
        return new ResponseEntity<>(tiposDeCargas, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCargas> getTiposDeCargasById(@PathVariable Integer id) {
        TiposDeCargas tiposDeCargas = tiposDeCargasService.getTiposDeCargasById(id);
        if (tiposDeCargas != null) {
            return new ResponseEntity<>(tiposDeCargas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TiposDeCargas> deleteTiposDeCargasById(@PathVariable Integer id) {
        TiposDeCargas tiposDeCargas = tiposDeCargasService.getTiposDeCargasById(id);
        if (tiposDeCargas!= null) {
            tiposDeCargasService.deleteTiposDeCargas(id);
            return new ResponseEntity<>(tiposDeCargas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<TiposDeCargas> createTiposDeCargas(@RequestBody TiposDeCargas tiposDeCargas) {
        tiposDeCargasService.addTiposDeCargas(tiposDeCargas);
        return new ResponseEntity<>(tiposDeCargas, HttpStatus.CREATED);
    }
}
