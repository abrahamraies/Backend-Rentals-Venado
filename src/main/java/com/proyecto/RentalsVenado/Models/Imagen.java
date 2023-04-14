package com.proyecto.RentalsVenado.Models;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Imagen {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idimagen;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public Imagen(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
      }
}
