package com.proyecto.RentalsVenado.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMensaje {
    private String message;

    public ResponseMensaje(String message) {
        this.message = message;
    }
}
