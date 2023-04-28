package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.CondicionesDeEnvio;
import com.example.shipping.services.CondicionesDeEnvioService;

import java.util.List;


@RestController
@RequestMapping("/shipping/condicionesDeEnvio")
public class CondicionesDeEnvioController {
    @Autowired
    private CondicionesDeEnvioService condicionesDeEnvioService;

    @GetMapping
    public ResponseEntity<List<CondicionesDeEnvio>> getAllCondicionesDeEnvio() {
        return ResponseEntity.ok(condicionesDeEnvioService.getAllCondicionesDeEnvio());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionesDeEnvio> updateCondicionesDeEnvio(@PathVariable Integer id, @RequestBody CondicionesDeEnvio condicionesDeEnvio) {
        if (condicionesDeEnvioService.getCondicionesDeEnvioById(id) != null) {
            condicionesDeEnvioService.updateCondicionesDeEnvio(id, condicionesDeEnvio);
            return new ResponseEntity<>(condicionesDeEnvio, HttpStatus.OK);
        }
        return new ResponseEntity<>(condicionesDeEnvio, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CondicionesDeEnvio> getCondicionesDeEnvioById(@PathVariable Integer id) {
        CondicionesDeEnvio condicionesDeEnvio = condicionesDeEnvioService.getCondicionesDeEnvioById(id);
        if (condicionesDeEnvio != null) {
            return new ResponseEntity<>(condicionesDeEnvio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CondicionesDeEnvio> deleteCondicionesDeEnvioById(@PathVariable Integer id) {
        CondicionesDeEnvio condicionesDeEnvio = condicionesDeEnvioService.getCondicionesDeEnvioById(id);
        if (condicionesDeEnvio!= null) {
            condicionesDeEnvioService.deleteCondicionesDeEnvio(id);
            return new ResponseEntity<>(condicionesDeEnvio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<CondicionesDeEnvio> createCondicionesDeEnvio(@RequestBody CondicionesDeEnvio condicionesDeEnvio) {
        condicionesDeEnvioService.addCondicionesDeEnvio(condicionesDeEnvio);
        return new ResponseEntity<>(condicionesDeEnvio, HttpStatus.CREATED);
    }
}
