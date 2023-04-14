package com.proyecto.proyecto_alquiler_vehiculos.controller;

import java.util.List;

import com.proyecto.proyecto_alquiler_vehiculos.Repository.ClienteRepository;
import com.proyecto.proyecto_alquiler_vehiculos.exceptions.ResourceNotFoundExceptions;
import com.proyecto.proyecto_alquiler_vehiculos.Models.Cliente;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://rentals-venado.web.app")
@RequestMapping("/RentalsVenado/clientes")
public class ClienteController {
	
	private final ClienteRepository repositorio;

    public ClienteController(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/lista")
    public List<Cliente> listarClientes() {
        return repositorio.findAll();
    }

    @PostMapping("/registrarCliente")
    public Cliente crearCliente(@RequestBody Cliente nuevoCliente) {
        return repositorio.save(nuevoCliente);
    }

    @PutMapping("/actualizarCliente/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente nuevoCliente) {
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe un cliente con el id: " + id));

        cliente.setNombre(nuevoCliente.getNombre());
        cliente.setApellido(nuevoCliente.getApellido());
        cliente.setDni(nuevoCliente.getDni());
        cliente.setCorreo(nuevoCliente.getCorreo());
        cliente.setFechanac(nuevoCliente.getFechanac());
        cliente.setCelular(nuevoCliente.getCelular());
        cliente.setDireccion(nuevoCliente.getDireccion());
        cliente.setCodpostal(nuevoCliente.getCodpostal());
        cliente.setNacionalidad(nuevoCliente.getNacionalidad());
        cliente.setPassword(nuevoCliente.getPassword());

        Cliente clienteActualizado = repositorio.save(cliente);

        return ResponseEntity.ok(clienteActualizado);
    }

    @GetMapping("/loginCliente")
    public ResponseEntity<Cliente> loginCliente(@RequestParam String correo, @RequestParam String pass) {
        Cliente cliente = repositorio.findByCorreo(correo)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe un cliente con el correo ingresado " + correo));

        if (cliente.getPassword().equals(pass)) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
