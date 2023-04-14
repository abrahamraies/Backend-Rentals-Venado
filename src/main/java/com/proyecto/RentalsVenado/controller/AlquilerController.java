package com.proyecto.RentalsVenado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.RentalsVenado.Models.RegistroAlquiler;
import com.proyecto.RentalsVenado.Repository.AlquilerRepository;

@RestController
@CrossOrigin("https://rentals-venado.web.app")
@RequestMapping("/RentalsVenado")
public class AlquilerController {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @PostMapping("/registrarAlquiler")
    public RegistroAlquiler registrarAlquiler(@RequestBody RegistroAlquiler nuevoAlquiler) {
        return alquilerRepository.save(nuevoAlquiler);
    }

}
