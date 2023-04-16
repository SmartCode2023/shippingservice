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
@Table(name = "envios")
public class Envios implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer contratoId;
    @Column
    private Integer direccionOrigenId;
    @Column
    private Integer direccionDestinoId;
    @Column
    private Integer vehiculoId;
    @Column
    private Integer conductorId;
    @Column
    private String marcaDeTiempoInicio;
    @Column
    private String marcaDeTiempoFin;
    @Column
    private Integer estadoDeEnvioId;
    @Column
    private Integer tiposEnviosId;
}
