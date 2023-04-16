package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.Paises;
import com.example.shipping.services.PaisesService;

import java.util.List;


@RestController
@RequestMapping("/paises")
public class PaisesController {
    @Autowired
    private PaisesService paisesService;

    @GetMapping
    public ResponseEntity<List<Paises>> getAllPaises() {
        return ResponseEntity.ok(paisesService.getAllPaises());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paises> updatePaises(@PathVariable Integer id, @RequestBody Paises paises) {
        if (paisesService.getPaisesById(id) != null) {
            paisesService.updatePaises(id, paises);
            return new ResponseEntity<>(paises, HttpStatus.OK);
        }
        return new ResponseEntity<>(paises, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Paises> getPaisesById(@PathVariable Integer id) {
        Paises paises = paisesService.getPaisesById(id);
        if (paises != null) {
            return new ResponseEntity<>(paises, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paises> deletePaisesById(@PathVariable Integer id) {
        Paises paises = paisesService.getPaisesById(id);
        if (paises!= null) {
            paisesService.deletePaises(id);
            return new ResponseEntity<>(paises, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Paises> createPaises(@RequestBody Paises paises) {
        paisesService.addPaises(paises);
        return new ResponseEntity<>(paises, HttpStatus.CREATED);
    }
}
