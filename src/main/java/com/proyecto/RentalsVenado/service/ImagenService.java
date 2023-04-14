package com.proyecto.RentalsVenado.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.RentalsVenado.Models.Imagen;
import com.proyecto.RentalsVenado.Repository.ImageRepository;

@Service
public class ImagenService {
    
    @Autowired
    private ImageRepository imagenRepositorio;

    // Este metodo se encarga de asignar los valores de la imagen en su respectiva tabla
    public String store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Imagen FileDB = new Imagen(fileName, file.getContentType(), file.getBytes());

        imagenRepositorio.save(FileDB);

        return FileDB.getIdimagen();
    }

    // Este metodo se encarga de obtener una imagen segun su id
    public Imagen getFile(String id) {
        return imagenRepositorio.findById(id).get();
    }
    
    // Este metodo se encarga de obtener todas las imagenes de la tabla
    public Stream<Imagen> getAllFiles() {
        return imagenRepositorio.findAll().stream();
    }

}
