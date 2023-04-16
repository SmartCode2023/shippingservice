package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.Direcciones;
import com.example.shipping.model.Envios;
import com.example.shipping.model.EstadosDeEnvios;
import com.example.shipping.model.TiposEnvios;
import com.example.shipping.model.Vehiculos;
import com.example.shipping.services.DireccionesService;
import com.example.shipping.services.EnviosService;
import com.example.shipping.services.EstadosDeEnviosService;
import com.example.shipping.services.TiposEnviosService;
import com.example.shipping.services.VehiculosService;

import java.util.List;


@RestController
@RequestMapping("/envios")
public class EnviosController {
    @Autowired
    private EnviosService enviosService;

    @Autowired
    private DireccionesService direccionesService;
    @Autowired
    private VehiculosService vehiculosService;
    @Autowired
    private EstadosDeEnviosService estadosDeEnviosService;
    @Autowired
    private TiposEnviosService tiposEnviosService;

    @GetMapping
    public ResponseEntity<List<Envios>> getAllEnvios() {
        return ResponseEntity.ok(enviosService.getAllEnvios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envios> getEnviosById(@PathVariable Integer id) {
        Envios envios = enviosService.getEnviosById(id);
        if (envios != null) {
            return new ResponseEntity<>(envios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Envios> createEnvios(@RequestBody Envios envios) {

        Direcciones direccionDestino = direccionesService.getDireccionesById(envios.getDireccionDestinoId());
        Direcciones direccionOrigen = direccionesService.getDireccionesById(envios.getDireccionOrigenId());
        Vehiculos vehiculo = vehiculosService.getVehiculosById(envios.getVehiculoId());


        EstadosDeEnvios estadosDeEnvios = estadosDeEnviosService.getEstadosDeEnviosById(envios.getEstadoDeEnvioId());
        TiposEnvios tiposEnvios =tiposEnviosService.getTiposEnviosById(envios.getTiposEnviosId());

        
        if (direccionDestino!= null &&  direccionOrigen!= null && vehiculo!= null && estadosDeEnvios!= null && tiposEnvios!= null) {
            enviosService.addEnvios(envios);
            return new ResponseEntity<>(envios, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Envios> deleteEnviosById(@PathVariable Integer id) {
        Envios envios = enviosService.getEnviosById(id);
        if (envios!= null) {
            enviosService.deleteEnvios(id);
            return new ResponseEntity<>(envios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envios> updateEnvios(@PathVariable Integer id, @RequestBody Envios envios) {
        if (enviosService.getEnviosById(id) != null) {
            Direcciones direccionDestino = direccionesService.getDireccionesById(envios.getDireccionDestinoId());
            Direcciones direccionOrigen = direccionesService.getDireccionesById(envios.getDireccionOrigenId());
            Vehiculos vehiculo = vehiculosService.getVehiculosById(envios.getVehiculoId());
    
            EstadosDeEnvios estadosDeEnvios = estadosDeEnviosService.getEstadosDeEnviosById(envios.getEstadoDeEnvioId());
            TiposEnvios tiposEnvios =tiposEnviosService.getTiposEnviosById(envios.getTiposEnviosId());
            
            if (direccionDestino!= null &&  direccionOrigen!= null && vehiculo!= null && estadosDeEnvios!= null && tiposEnvios!= null) {
                enviosService.updateEnvios(id, envios);
                return new ResponseEntity<>(envios, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
