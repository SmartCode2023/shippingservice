package com.example.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shipping.model.InfoCotizar;

import java.util.List;


@RestController
@RequestMapping("/shipping/cotizar")
public class CotizacionController {

    @GetMapping
    public ResponseEntity<Double> cotizar(@RequestBody InfoCotizar infoCotizar){
        double total = (( (infoCotizar.getPeso()*(15/10)) + 50) *1000) + (1000 * (infoCotizar.getAlto()*infoCotizar.getAncho()*infoCotizar.getLargo()));
        total = total*1.19;   //Iva del 19%
        
        if(infoCotizar.getNacional()== false){
            total = total * 1.09;    
        }
        
        return ResponseEntity.ok(total);
    }
}
