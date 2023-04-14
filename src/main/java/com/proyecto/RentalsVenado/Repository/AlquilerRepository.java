package com.proyecto.RentalsVenado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.RentalsVenado.Models.RegistroAlquiler;


public interface AlquilerRepository extends JpaRepository<RegistroAlquiler,Long>{

}