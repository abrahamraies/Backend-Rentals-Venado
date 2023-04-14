package com.proyecto.RentalsVenado.Models;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegistroAlquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idregistroalquiler")
    private Long idregistroalquiler;
    
    private Long idvehiculo;
    private int idcliente;
    private LocalDate fechainicio;
    private LocalDate fechafin;

}
