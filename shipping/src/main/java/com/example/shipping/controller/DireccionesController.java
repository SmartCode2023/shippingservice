package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.Ciudades;
import com.example.shipping.model.DepartamentosEstados;
import com.example.shipping.model.Direcciones;
import com.example.shipping.model.Paises;
import com.example.shipping.services.CiudadesService;
import com.example.shipping.services.DepartamentosEstadosService;
import com.example.shipping.services.DireccionesService;
import com.example.shipping.services.PaisesService;

import java.util.List;


@RestController
@RequestMapping("/shipping/direcciones")
public class DireccionesController {
    @Autowired
    private DireccionesService direccionesService;

    @Autowired
    private PaisesService paisesService;
    @Autowired
    private DepartamentosEstadosService departamentosEstadosService;
    @Autowired
    private CiudadesService ciudadesService;

    @GetMapping
    public ResponseEntity<List<Direcciones>> getAllDirecciones() {
        return ResponseEntity.ok(direccionesService.getAllDirecciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direcciones> getDireccionesById(@PathVariable Integer id) {
        Direcciones direcciones = direccionesService.getDireccionesById(id);
        if (direcciones != null) {
            return new ResponseEntity<>(direcciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Direcciones> createDirecciones(@RequestBody Direcciones direcciones) {

        Paises paises = paisesService.getPaisesById(direcciones.getPaisId());
        DepartamentosEstados departamentosEstados = departamentosEstadosService.getDepartamentosEstadosById(direcciones.getPaisId());
        Ciudades ciudades = ciudadesService.getCiudadesById(direcciones.getPaisId());
        
        if (paises!= null &&  departamentosEstados!= null && ciudades!= null) {
            direccionesService.addDirecciones(direcciones);
            return new ResponseEntity<>(direcciones, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Direcciones> deleteDireccionesById(@PathVariable Integer id) {
        Direcciones direcciones = direccionesService.getDireccionesById(id);
        if (direcciones!= null) {
            direccionesService.deleteDirecciones(id);
            return new ResponseEntity<>(direcciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direcciones> updateDirecciones(@PathVariable Integer id, @RequestBody Direcciones direcciones) {
        if (direccionesService.getDireccionesById(id) != null) {
            Paises paises = paisesService.getPaisesById(direcciones.getPaisId());
            DepartamentosEstados departamentosEstados = departamentosEstadosService.getDepartamentosEstadosById(direcciones.getPaisId());
            Ciudades ciudades = ciudadesService.getCiudadesById(direcciones.getPaisId());
            
            if (paises!= null &&  departamentosEstados!= null && ciudades!= null) {
                direccionesService.updateDirecciones(id, direcciones);
                return new ResponseEntity<>(direcciones, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
