package com.proyecto.RentalsVenado.Models;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idvehiculo")
    private Long idvehiculo;
    
    @Column(name = "idempresa")
    private Long idempresa;
    private String marca;
    private String modelo;
    private int anio;
    private String patente;
    private String tamanio;
    private String categoria;
    private Float precioalquiler;
    private boolean disponible;
    private String imagen;

}
