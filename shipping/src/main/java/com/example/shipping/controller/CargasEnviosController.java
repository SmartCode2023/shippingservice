package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.Cargas;
import com.example.shipping.model.CargasEnviosCondicionesDeRiesgo;
import com.example.shipping.model.CondicionesDeRiesgo;
import com.example.shipping.services.CargasEnviosCondicionesDeRiesgoService;
import com.example.shipping.services.CargasService;
import com.example.shipping.services.CondicionesDeRiesgoService;

import java.util.List;


@RestController
@RequestMapping("/shipping/cargasEnviosCondicionesDeRiesgo")
public class CargasEnviosController {
    @Autowired
    private CargasEnviosCondicionesDeRiesgoService cargasEnviosCondicionesDeRiesgoService;

    @Autowired
    private CargasService cargasService;
    @Autowired
    private CondicionesDeRiesgoService condicionesDeRiesgoService;

    @GetMapping
    public ResponseEntity<List<CargasEnviosCondicionesDeRiesgo>> getAllCargasEnviosCondicionesDeRiesgo() {
        return ResponseEntity.ok(cargasEnviosCondicionesDeRiesgoService.getAllCargasEnviosCondicionesDeRiesgo());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargasEnviosCondicionesDeRiesgo> updateCargasEnviosCondicionesDeRiesgo(@PathVariable Integer id, @RequestBody CargasEnviosCondicionesDeRiesgo cargasEnviosCondicionesDeRiesgo) {
        if (cargasEnviosCondicionesDeRiesgoService.getCargasEnviosCondicionesDeRiesgoById(id) != null) {
            
            Cargas cargas = cargasService.getCargasById(cargasEnviosCondicionesDeRiesgo.getCargaId());

            CondicionesDeRiesgo condicionesDeRiesgo = condicionesDeRiesgoService.getCondicionesDeRiesgoById(cargasEnviosCondicionesDeRiesgo.getCondicionDeRiesgoId());
            
            if (cargas!= null &&  condicionesDeRiesgo!= null ) {
                cargasEnviosCondicionesDeRiesgoService.updateCargasEnviosCondicionesDeRiesgo(id, cargasEnviosCondicionesDeRiesgo);
                return new ResponseEntity<>(cargasEnviosCondicionesDeRiesgo, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CargasEnviosCondicionesDeRiesgo> getCargasEnviosCondicionesDeRiesgoById(@PathVariable Integer id) {
        
        CargasEnviosCondicionesDeRiesgo cargasEnviosCondicionesDeRiesgo = cargasEnviosCondicionesDeRiesgoService.getCargasEnviosCondicionesDeRiesgoById(id);
        if (cargasEnviosCondicionesDeRiesgo != null) {
            return new ResponseEntity<>(cargasEnviosCondicionesDeRiesgo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CargasEnviosCondicionesDeRiesgo> deleteCargasEnviosCondicionesDeRiesgoById(@PathVariable Integer id) {
        CargasEnviosCondicionesDeRiesgo cargasEnviosCondicionesDeRiesgo = cargasEnviosCondicionesDeRiesgoService.getCargasEnviosCondicionesDeRiesgoById(id);
        if (cargasEnviosCondicionesDeRiesgo!= null) {
            cargasEnviosCondicionesDeRiesgoService.deleteCargasEnviosCondicionesDeRiesgo(id);
            return new ResponseEntity<>(cargasEnviosCondicionesDeRiesgo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<CargasEnviosCondicionesDeRiesgo> createCargas(@RequestBody CargasEnviosCondicionesDeRiesgo cargasEnviosCondicionesDeRiesgo) {

        Cargas cargas = cargasService.getCargasById(cargasEnviosCondicionesDeRiesgo.getCargaId());
        CondicionesDeRiesgo condicionesDeRiesgo = condicionesDeRiesgoService.getCondicionesDeRiesgoById(cargasEnviosCondicionesDeRiesgo.getCondicionDeRiesgoId());
            
        if (cargas!= null &&  condicionesDeRiesgo!= null ) {
            cargasEnviosCondicionesDeRiesgoService.addCargasEnviosCondicionesDeRiesgo(cargasEnviosCondicionesDeRiesgo);
            return new ResponseEntity<>(cargasEnviosCondicionesDeRiesgo, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
