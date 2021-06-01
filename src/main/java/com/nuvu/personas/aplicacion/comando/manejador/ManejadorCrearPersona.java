package com.nuvu.personas.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.nuvu.personas.aplicacion.comando.ComandoPersona;
import com.nuvu.personas.aplicacion.comando.fabrica.FabricaPersona;
import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.dominio.servicio.ServicioCrearPersona;

@Component
public class ManejadorCrearPersona {
	
	private ServicioCrearPersona servicioCrearPersona;
	private FabricaPersona fabricaPersona;
	
	public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {
		this.servicioCrearPersona = servicioCrearPersona;
		this.fabricaPersona = fabricaPersona;
	}
	
	public void crear(ComandoPersona comandoPersona) {
		Persona persona = fabricaPersona.crear(comandoPersona);
		servicioCrearPersona.crear(persona);
	}
}
