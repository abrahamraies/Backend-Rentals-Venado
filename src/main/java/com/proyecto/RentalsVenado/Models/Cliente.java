package com.proyecto.RentalsVenado.Models;

import java.sql.Date;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idcliente")
    private Long idcliente;

    private String nombre;
    private String apellido;
    private String dni;
    private String cuit;
    @Column(name = "correo",unique = true)
    private String correo;
    private Date fechanac;
    private String celular;
    private String direccion;
    private String codpostal;
    private String nacionalidad;
    private String password;
    private int rol = 1;

}
