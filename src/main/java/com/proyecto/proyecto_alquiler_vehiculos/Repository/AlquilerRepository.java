package com.proyecto.proyecto_alquiler_vehiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.proyecto_alquiler_vehiculos.Models.RegistroAlquiler;


public interface AlquilerRepository extends JpaRepository<RegistroAlquiler,Long>{

}