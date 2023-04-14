package com.proyecto.proyecto_alquiler_vehiculos.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    // Este metodo se encarga de resolver el problema de CORS
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
    
}