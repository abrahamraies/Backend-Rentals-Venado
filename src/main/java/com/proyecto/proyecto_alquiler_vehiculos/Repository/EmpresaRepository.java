package com.proyecto.proyecto_alquiler_vehiculos.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.proyecto_alquiler_vehiculos.Models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,Long>{
    
    // Este metodo se encarga de encontrar a una empresa por su correo
    Optional<Empresa> findByCorreo(String correo);

}