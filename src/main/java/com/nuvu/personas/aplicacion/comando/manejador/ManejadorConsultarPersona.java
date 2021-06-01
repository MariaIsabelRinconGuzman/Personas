package com.nuvu.personas.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.dominio.servicio.ServicioConsultarPersona;

@Component
public class ManejadorConsultarPersona {
	
	private ServicioConsultarPersona servicioConsultarPersona;

	public ManejadorConsultarPersona(ServicioConsultarPersona servicioConsultarPersona) {
		this.servicioConsultarPersona = servicioConsultarPersona;
	}	

	public Persona consultar(Long identificacion) {
		return servicioConsultarPersona.consultar(identificacion);
	}
}
