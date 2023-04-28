package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.shipping.model.TiposEnvios;
import com.example.shipping.services.TiposEnviosService;


@RestController
@RequestMapping("/shipping/tiposEnvios")
public class TiposEnviosController {
    @Autowired
    private TiposEnviosService tiposEnviosService;

    @GetMapping
    public ResponseEntity<List<TiposEnvios>> getAllTiposEnvios() {
        return ResponseEntity.ok(tiposEnviosService.getAllTiposEnvios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiposEnvios> updateTiposEnvios(@PathVariable Integer id, @RequestBody TiposEnvios tiposEnvios) {
        if (tiposEnviosService.getTiposEnviosById(id) != null) {
            tiposEnviosService.updateTiposEnvios(id, tiposEnvios);
            return new ResponseEntity<>(tiposEnvios, HttpStatus.OK);
        }
        return new ResponseEntity<>(tiposEnvios, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TiposEnvios> getTiposEnviosById(@PathVariable Integer id) {
        TiposEnvios tiposEnvios = tiposEnviosService.getTiposEnviosById(id);
        if (tiposEnvios != null) {
            return new ResponseEntity<>(tiposEnvios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TiposEnvios> deleteTiposEnviosById(@PathVariable Integer id) {
        TiposEnvios tiposEnvios = tiposEnviosService.getTiposEnviosById(id);
        if (tiposEnvios!= null) {
            tiposEnviosService.deleteTiposEnvios(id);
            return new ResponseEntity<>(tiposEnvios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<TiposEnvios> createTiposEnvios(@RequestBody TiposEnvios tiposEnvios) {
        tiposEnviosService.addTiposEnvios(tiposEnvios);
        return new ResponseEntity<>(tiposEnvios, HttpStatus.CREATED);
    }
}
