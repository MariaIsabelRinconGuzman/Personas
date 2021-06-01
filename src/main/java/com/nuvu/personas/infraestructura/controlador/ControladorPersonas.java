package com.nuvu.personas.infraestructura.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.personas.aplicacion.comando.ComandoPersona;
import com.nuvu.personas.aplicacion.comando.manejador.ManejadorActualizarPersona;
import com.nuvu.personas.aplicacion.comando.manejador.ManejadorConsultarPersona;
import com.nuvu.personas.aplicacion.comando.manejador.ManejadorCrearPersona;
import com.nuvu.personas.dominio.dto.Persona;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/persona")
public class ControladorPersonas {
	
	private final ManejadorCrearPersona manejadorCrearPersona;
	private final ManejadorConsultarPersona manejadorConsultarPersona;
	private final ManejadorActualizarPersona manejadorActualizarPersona;
		
	public ControladorPersonas(ManejadorCrearPersona manejadorCrearPersona,
			ManejadorConsultarPersona manejadorConsultarPersona,
			ManejadorActualizarPersona manejadorActualizarPersona) {
		this.manejadorCrearPersona = manejadorCrearPersona;
		this.manejadorConsultarPersona = manejadorConsultarPersona;
		this.manejadorActualizarPersona = manejadorActualizarPersona;
	}

	@PostMapping
    @ResponseStatus(HttpStatus.OK)
	public void crear(@RequestBody ComandoPersona comandoPersona) {
		manejadorCrearPersona.crear(comandoPersona);
	}

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public Persona consultar(@RequestHeader Long identificacion) {
		return manejadorConsultarPersona.consultar(identificacion);
	}
	
	@PutMapping
    @ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody ComandoPersona comandoPersona) {
		manejadorActualizarPersona.actualizar(comandoPersona);
	}
}
