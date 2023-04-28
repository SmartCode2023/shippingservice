package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.UnidadesDimensiones;
import com.example.shipping.services.UnidadesDimensionesService;

import java.util.List;


@RestController
@RequestMapping("/shipping/unidadesDimensiones")
public class UnidadesDimensionesController {
    @Autowired
    private UnidadesDimensionesService unidadesDimensionesService;

    @GetMapping
    public ResponseEntity<List<UnidadesDimensiones>> getAllUnidadesDimensiones() {
        return ResponseEntity.ok(unidadesDimensionesService.getAllUnidadesDimensiones());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadesDimensiones> updateUnidadesDimensiones(@PathVariable Integer id, @RequestBody UnidadesDimensiones unidadesDimensiones) {
        if (unidadesDimensionesService.getUnidadesDimensionesById(id) != null) {
            unidadesDimensionesService.updateUnidadesDimensiones(id, unidadesDimensiones);
            return new ResponseEntity<>(unidadesDimensiones, HttpStatus.OK);
        }
        return new ResponseEntity<>(unidadesDimensiones, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UnidadesDimensiones> getUnidadesDimensionesById(@PathVariable Integer id) {
        UnidadesDimensiones unidadesDimensiones = unidadesDimensionesService.getUnidadesDimensionesById(id);
        if (unidadesDimensiones != null) {
            return new ResponseEntity<>(unidadesDimensiones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UnidadesDimensiones> deleteUnidadesDimensionesById(@PathVariable Integer id) {
        UnidadesDimensiones unidadesDimensiones = unidadesDimensionesService.getUnidadesDimensionesById(id);
        if (unidadesDimensiones!= null) {
            unidadesDimensionesService.deleteUnidadesDimensiones(id);
            return new ResponseEntity<>(unidadesDimensiones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<UnidadesDimensiones> createUnidadesDimensiones(@RequestBody UnidadesDimensiones unidadesDimensiones) {
        unidadesDimensionesService.addUnidadesDimensiones(unidadesDimensiones);
        return new ResponseEntity<>(unidadesDimensiones, HttpStatus.CREATED);
    }
}
