package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.DepartamentosEstados;
import com.example.shipping.model.Paises;
import com.example.shipping.services.DepartamentosEstadosService;
import com.example.shipping.services.PaisesService;

import java.util.List;


@RestController
@RequestMapping("/shipping/departamentosEstados")
public class DepartamentosEstadosController {
    @Autowired
    private PaisesService paisesService;

    @Autowired
    private DepartamentosEstadosService departamentosEstadosService;
    @GetMapping
    public ResponseEntity<List<DepartamentosEstados>> getAllDepartamentosEstados() {
        return ResponseEntity.ok(departamentosEstadosService.getAllDepartamentosEstados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentosEstados> getDepartamentosEstadosById(@PathVariable Integer id) {
        DepartamentosEstados departamentosEstados = departamentosEstadosService.getDepartamentosEstadosById(id);
        if (departamentosEstados != null) {
            return new ResponseEntity<>(departamentosEstados, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<DepartamentosEstados> createDepartamentosEstados(@RequestBody DepartamentosEstados departamentosEstados) {

        Paises pais = paisesService.getPaisesById(departamentosEstados.getPaisId());
        if (pais!= null){
            departamentosEstadosService.addDepartamentosEstados(departamentosEstados);
            return new ResponseEntity<>(departamentosEstados, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DepartamentosEstados> deleteDepartamentosEstadosById(@PathVariable Integer id) {
        DepartamentosEstados departamentosEstados = departamentosEstadosService.getDepartamentosEstadosById(id);
        if (departamentosEstados!= null) {
            departamentosEstadosService.deleteDepartamentosEstados(id);
            return new ResponseEntity<>(departamentosEstados, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentosEstados> updateDepartamentosEstados(@PathVariable Integer id, @RequestBody DepartamentosEstados departamentosEstados) {
        if (departamentosEstadosService.getDepartamentosEstadosById(id) != null) {
            Paises pais = paisesService.getPaisesById(departamentosEstados.getPaisId());
            if (pais!= null ){
                departamentosEstadosService.updateDepartamentosEstados(id, departamentosEstados);
                return new ResponseEntity<>(departamentosEstados, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
