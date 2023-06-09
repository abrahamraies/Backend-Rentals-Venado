package com.proyecto.RentalsVenado.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.RentalsVenado.Models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,Long>{
    
    // Este metodo se encarga de encontrar a una empresa por su correo
    Optional<Empresa> findByCorreo(String correo);

}