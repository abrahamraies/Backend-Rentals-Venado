package com.proyecto.RentalsVenado.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.RentalsVenado.Models.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long>{

    // Este metodo se encarga de devolver todos los vehiculos segun el id de una empresa como parametro
    List<Vehiculo> findAllByidempresa(Long idempresa);

}