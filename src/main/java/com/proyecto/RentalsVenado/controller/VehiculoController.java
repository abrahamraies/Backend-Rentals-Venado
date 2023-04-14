package com.proyecto.RentalsVenado.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.RentalsVenado.exceptions.ResourceNotFoundExceptions;
import com.proyecto.RentalsVenado.Models.*;

import com.proyecto.RentalsVenado.Repository.*;
import com.proyecto.RentalsVenado.service.ImagenService;


@RestController
@CrossOrigin(origins = "https://rentals-venado.web.app")
@RequestMapping("/RentalsVenado")
public class VehiculoController {

	@Autowired
	private VehiculoRepository repositorioV;

	@Autowired
  	private ImagenService storageService;

	String imagenid = new String();

	// Este metodo lista todos los vehiculos disponibles
	@GetMapping("/vehiculos")
	public List<Vehiculo> ListarVehiculos() {

		return repositorioV.findAll();
	}

	// Este método se encarga de obtener un vehiculo seleccionado
	@GetMapping("/obtenerVehiculo/{id}")
	public ResponseEntity<Vehiculo> ObtenerVehiculo(@PathVariable Long id) {

		Vehiculo vehiculo = repositorioV.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehiculo con el id: " + id));

		return ResponseEntity.ok(vehiculo);
	}

	// Este metodo se encarga de actualizar el estado de un vehiculo
	@PutMapping("/actualizarVehiculo/{id}")
	public ResponseEntity<Vehiculo> ActualizarVehiculo(@PathVariable Long id, @RequestBody Vehiculo nuevoVehiculo) {

		Vehiculo vehiculo = repositorioV.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehiculo con el id: " + id));

		vehiculo.setIdempresa(nuevoVehiculo.getIdempresa());
		vehiculo.setMarca(nuevoVehiculo.getMarca());
		vehiculo.setModelo(nuevoVehiculo.getModelo());
		vehiculo.setAnio(nuevoVehiculo.getAnio());
		vehiculo.setPatente(nuevoVehiculo.getPatente());
		vehiculo.setTamanio(nuevoVehiculo.getTamanio());
		vehiculo.setCategoria(nuevoVehiculo.getCategoria());
		vehiculo.setPrecioalquiler(nuevoVehiculo.getPrecioalquiler());
		vehiculo.setDisponible(nuevoVehiculo.isDisponible());
		vehiculo.setImagen("http://localhost:8080/RentalsVenado/files/"+imagenid);

		Vehiculo vehiculoActualizado = repositorioV.save(vehiculo);

		return ResponseEntity.ok(vehiculoActualizado);
	}

	// Este metodo se encarga de deshabilitar un vehiculo
	@GetMapping("/eliminarVehiculo/{id}")
	public ResponseEntity<Vehiculo> EliminarVehiculo(@PathVariable Long id) {

		Vehiculo vehiculo = repositorioV.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehiculo con el id: " + id));

		vehiculo.setDisponible(false);

		repositorioV.save(vehiculo);

		return ResponseEntity.ok(vehiculo);
	}

	// Este metodo se encarga de habilitar un vehiculo
	@GetMapping("/habilitarVehiculo/{id}")
	public ResponseEntity<Vehiculo> HabilitarVehiculo(@PathVariable Long id) {

		Vehiculo vehiculo = repositorioV.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("No existe un vehiculo con el id: " + id));

		vehiculo.setDisponible(true);

		repositorioV.save(vehiculo);

		return ResponseEntity.ok(vehiculo);
	}

	// Este metodo se encarga de registrar un nuevo vehiculo
	@PostMapping("/registrarVehiculo")
	public Vehiculo CrearVehiculo(@RequestBody Vehiculo nuevoVehiculo) {
		nuevoVehiculo.setDisponible(true);
		nuevoVehiculo.setImagen("http://localhost:8080/RentalsVenado/files/"+imagenid);

		return repositorioV.save(nuevoVehiculo);
	}

	//#region Imagen
	// Este metodo se encarga de cargar una imagen en su respectiva tabla
	@PostMapping("/upload")
	public ResponseEntity<ResponseMensaje> uploadFile(@RequestParam MultipartFile file) {
		String message = "";
		try {
		imagenid = storageService.store(file);
		message = "Upload completed "+ file.getOriginalFilename();
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMensaje(message));
		} catch (Exception e) {
		message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMensaje(message));
		}
	}

	// Este metodo se encarga de obtener todas las imagenes
	@GetMapping("/files")
	public ResponseEntity<List<ResponseImagen>> getListFiles() {
		List<ResponseImagen> files = storageService.getAllFiles().map(dbFile -> {
		String fileDownloadUri = ServletUriComponentsBuilder
			.fromCurrentContextPath()
			.path("RentalsVenado/files/")
			.path(dbFile.getIdimagen())
			.toUriString();

		return new ResponseImagen(
			dbFile.getName(),
			fileDownloadUri,
			dbFile.getType(),
			dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	// Este metodo se encarga de obtener la imagen segun el parámetro enviado
		@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		Imagen fileDB = storageService.getFile(id);

		return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
			.body(fileDB.getData());
	}
	//#endregion



}
