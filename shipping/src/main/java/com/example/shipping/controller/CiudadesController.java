package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.Ciudades;
import com.example.shipping.model.DepartamentosEstados;
import com.example.shipping.services.CiudadesService;
import com.example.shipping.services.DepartamentosEstadosService;

import java.util.List;


@RestController
@RequestMapping("/shipping/ciudades")
public class CiudadesController {
    @Autowired
    private CiudadesService ciudadesService;

    @Autowired
    private DepartamentosEstadosService departamentosEstadosService;
    @GetMapping
    public ResponseEntity<List<Ciudades>> getAllCiudades() {
        return ResponseEntity.ok(ciudadesService.getAllCiudades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudades> getCiudadesById(@PathVariable Integer id) {
        Ciudades ciudades = ciudadesService.getCiudadesById(id);
        if (ciudades != null) {
            return new ResponseEntity<>(ciudades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Ciudades> createCiudades(@RequestBody Ciudades ciudades) {

        DepartamentosEstados departamentosEstados = departamentosEstadosService.getDepartamentosEstadosById(ciudades.getDepartamentoEstadoId());
        if (departamentosEstados!= null){
            ciudadesService.addCiudades(ciudades);
            return new ResponseEntity<>(ciudades, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Ciudades> deleteCiudadesById(@PathVariable Integer id) {
        Ciudades ciudades = ciudadesService.getCiudadesById(id);
        if (ciudades!= null) {
            ciudadesService.deleteCiudades(id);
            return new ResponseEntity<>(ciudades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudades> updateCiudades(@PathVariable Integer id, @RequestBody Ciudades ciudades) {
        if (ciudadesService.getCiudadesById(id) != null) {
            DepartamentosEstados departamentosEstados = departamentosEstadosService.getDepartamentosEstadosById(ciudades.getDepartamentoEstadoId());

            if (departamentosEstados!= null ){
                ciudadesService.updateCiudades(id, ciudades);
                return new ResponseEntity<>(ciudades, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
