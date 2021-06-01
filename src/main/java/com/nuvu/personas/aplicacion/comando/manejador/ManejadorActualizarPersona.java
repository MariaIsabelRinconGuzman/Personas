package com.nuvu.personas.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.nuvu.personas.aplicacion.comando.ComandoPersona;
import com.nuvu.personas.aplicacion.comando.fabrica.FabricaPersona;
import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.dominio.servicio.ServicioActualizarPersona;

@Component
public class ManejadorActualizarPersona {
	
	private ServicioActualizarPersona servicioActualizarPersona;
	private FabricaPersona fabricaPersona;
	
	public ManejadorActualizarPersona(ServicioActualizarPersona servicioActualizarPersona,
			FabricaPersona fabricaPersona) {
		this.servicioActualizarPersona = servicioActualizarPersona;
		this.fabricaPersona = fabricaPersona;
	}

	public void actualizar(ComandoPersona comandoPersona) {
		Persona persona = fabricaPersona.crear(comandoPersona);
		servicioActualizarPersona.actualizar(persona);
	}
}
