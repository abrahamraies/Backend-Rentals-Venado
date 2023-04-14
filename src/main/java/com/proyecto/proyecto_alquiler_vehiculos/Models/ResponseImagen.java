package com.proyecto.proyecto_alquiler_vehiculos.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseImagen {
    private String name;
    private String url;
    private String type;
    private long size;

    public ResponseImagen(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }
}
