package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.CondicionesDeRiesgo;
import com.example.shipping.services.CondicionesDeRiesgoService;

import java.util.List;


@RestController
@RequestMapping("/condicionesDeRiesgo")
public class CondicionesDeRiesgoController {
    @Autowired
    private CondicionesDeRiesgoService condicionesDeRiesgoService;

    @GetMapping
    public ResponseEntity<List<CondicionesDeRiesgo>> getAllCondicionesDeRiesgo() {
        return ResponseEntity.ok(condicionesDeRiesgoService.getAllCondicionesDeRiesgo());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionesDeRiesgo> updateCondicionesDeRiesgo(@PathVariable Integer id, @RequestBody CondicionesDeRiesgo condicionesDeRiesgo) {
        if (condicionesDeRiesgoService.getCondicionesDeRiesgoById(id) != null) {
            condicionesDeRiesgoService.updateCondicionesDeRiesgo(id, condicionesDeRiesgo);
            return new ResponseEntity<>(condicionesDeRiesgo, HttpStatus.OK);
        }
        return new ResponseEntity<>(condicionesDeRiesgo, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CondicionesDeRiesgo> getCondicionesDeRiesgoById(@PathVariable Integer id) {
        CondicionesDeRiesgo condicionesDeRiesgo = condicionesDeRiesgoService.getCondicionesDeRiesgoById(id);
        if (condicionesDeRiesgo != null) {
            return new ResponseEntity<>(condicionesDeRiesgo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CondicionesDeRiesgo> deleteCondicionesDeRiesgoById(@PathVariable Integer id) {
        CondicionesDeRiesgo condicionesDeRiesgo = condicionesDeRiesgoService.getCondicionesDeRiesgoById(id);
        if (condicionesDeRiesgo!= null) {
            condicionesDeRiesgoService.deleteCondicionesDeRiesgo(id);
            return new ResponseEntity<>(condicionesDeRiesgo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<CondicionesDeRiesgo> createCondicionesDeRiesgo(@RequestBody CondicionesDeRiesgo condicionesDeRiesgo) {
        condicionesDeRiesgoService.addCondicionesDeRiesgo(condicionesDeRiesgo);
        return new ResponseEntity<>(condicionesDeRiesgo, HttpStatus.CREATED);
    }
}
