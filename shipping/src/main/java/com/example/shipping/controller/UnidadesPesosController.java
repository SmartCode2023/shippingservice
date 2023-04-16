package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.UnidadesPesos;
import com.example.shipping.services.UnidadesPesosService;

import java.util.List;


@RestController
@RequestMapping("/unidadesPesos")
public class UnidadesPesosController {
    @Autowired
    private UnidadesPesosService unidadesPesosService;

    @GetMapping
    public ResponseEntity<List<UnidadesPesos>> getAllUnidadesPesos() {
        return ResponseEntity.ok(unidadesPesosService.getAllUnidadesPesos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadesPesos> updateUnidadesPesos(@PathVariable Integer id, @RequestBody UnidadesPesos unidadesPesos) {
        if (unidadesPesosService.getUnidadesPesosById(id) != null) {
            unidadesPesosService.updateUnidadesPesos(id, unidadesPesos);
            return new ResponseEntity<>(unidadesPesos, HttpStatus.OK);
        }
        return new ResponseEntity<>(unidadesPesos, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UnidadesPesos> getUnidadesPesosById(@PathVariable Integer id) {
        UnidadesPesos unidadesPesos = unidadesPesosService.getUnidadesPesosById(id);
        if (unidadesPesos != null) {
            return new ResponseEntity<>(unidadesPesos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UnidadesPesos> deleteUnidadesPesosById(@PathVariable Integer id) {
        UnidadesPesos unidadesPesos = unidadesPesosService.getUnidadesPesosById(id);
        if (unidadesPesos!= null) {
            unidadesPesosService.deleteUnidadesPesos(id);
            return new ResponseEntity<>(unidadesPesos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<UnidadesPesos> createUnidadesPesos(@RequestBody UnidadesPesos unidadesPesos) {
        unidadesPesosService.addUnidadesPesos(unidadesPesos);
        return new ResponseEntity<>(unidadesPesos, HttpStatus.CREATED);
    }
}
