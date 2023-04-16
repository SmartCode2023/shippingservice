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
public class InfoCotizar {
    @Id
    private Integer id;
    private Boolean nacional;
    private Integer peso;
    private Integer largo;
    private Integer ancho;
    private Integer alto;
}
