package com.example.shipping.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cargas")
public class Cargas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer tipoDeCargaId;
    @Column
    private Integer envioId;
    @Column
    private Integer peso;
    @Column
    private Integer unidadePesoId;
    @Column
    private Integer largo;
    @Column
    private Integer ancho;
    @Column
    private Integer alto;
    @Column
    private Integer unidadDimensionesId;

}
