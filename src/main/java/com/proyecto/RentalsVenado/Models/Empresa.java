package com.proyecto.RentalsVenado.Models;

import javax.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idempresa")
    private Long idempresa;
    
    private String nombre;
    private String apellido;
    private String razonsocial;
    private String cuit;
    private String celular;
    private boolean habilitado;
    @Column(name = "correo",unique = true)
    private String correo;
    private String password;
    private int rol = 2;

}
