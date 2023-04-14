package com.proyecto.proyecto_alquiler_vehiculos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.proyecto_alquiler_vehiculos.Models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Long>{

    // Este metodo se encarga de encontrar a un cliente por su correo
    Optional<Cliente> findByCorreo(String correo);

    

}