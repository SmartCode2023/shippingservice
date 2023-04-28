package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.Cargas;
import com.example.shipping.model.Envios;
import com.example.shipping.model.TiposDeCargas;
import com.example.shipping.model.UnidadesDimensiones;
import com.example.shipping.model.UnidadesPesos;
import com.example.shipping.services.CargasService;
import com.example.shipping.services.EnviosService;
import com.example.shipping.services.TiposDeCargasService;
import com.example.shipping.services.UnidadesDimensionesService;
import com.example.shipping.services.UnidadesPesosService;

import java.util.List;


@RestController
@RequestMapping("/shipping/cargas")
public class CargasController {
    @Autowired
    private CargasService cargasService;

    @Autowired
    private TiposDeCargasService tiposDeCargasService;
    @Autowired
    private EnviosService enviosService;
    @Autowired
    private UnidadesPesosService unidadesPesosService;
    @Autowired
    private UnidadesDimensionesService unidadesDimensionesService;

    @GetMapping
    public ResponseEntity<List<Cargas>> getAllCargas(){
        return ResponseEntity.ok(cargasService.getAllCargas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargas> getCargasById(@PathVariable Integer id) {
        Cargas cargas = cargasService.getCargasById(id);
        if (cargas != null) {
            return new ResponseEntity<>(cargas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Cargas> createCargas(@RequestBody Cargas cargas) {

        TiposDeCargas tiposDeCargas = tiposDeCargasService.getTiposDeCargasById(cargas.getTipoDeCargaId());
        Envios envios = enviosService.getEnviosById(cargas.getEnvioId());
        UnidadesPesos unidadesPesos = unidadesPesosService.getUnidadesPesosById(cargas.getUnidadePesoId());
        UnidadesDimensiones unidadesDimensiones = unidadesDimensionesService.getUnidadesDimensionesById(cargas.getUnidadDimensionesId());

        
        if (tiposDeCargas!= null &&  envios!= null && unidadesPesos!= null && unidadesDimensiones!= null ) {
            cargasService.addCargas(cargas);
            return new ResponseEntity<>(cargas, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cargas> deleteCargasById(@PathVariable Integer id) {
        Cargas cargas = cargasService.getCargasById(id);
        if (cargas!= null) {
            cargasService.deleteCargas(id);
            return new ResponseEntity<>(cargas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargas> updateCargas(@PathVariable Integer id, @RequestBody Cargas cargas) {
        if (cargasService.getCargasById(id) != null) {
            TiposDeCargas tiposDeCargas = tiposDeCargasService.getTiposDeCargasById(cargas.getTipoDeCargaId());
            Envios envios = enviosService.getEnviosById(cargas.getEnvioId());
            UnidadesPesos unidadesPesos = unidadesPesosService.getUnidadesPesosById(cargas.getUnidadePesoId());
            UnidadesDimensiones unidadesDimensiones = unidadesDimensionesService.getUnidadesDimensionesById(cargas.getUnidadDimensionesId());
    
            if (tiposDeCargas!= null &&  envios!= null && unidadesPesos!= null && unidadesDimensiones!= null ) {
                cargasService.updateCargas(id, cargas);
                return new ResponseEntity<>(cargas, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
