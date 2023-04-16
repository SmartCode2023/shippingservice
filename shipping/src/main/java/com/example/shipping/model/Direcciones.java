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
@Table(name = "direcciones")
public class Direcciones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String direccion;
    @Column
    private Integer paisId;
    @Column
    private Integer departamentoEstadoId;
    @Column
    private Integer ciudadId;
    @Column
    private Integer codigoPostal;
}
