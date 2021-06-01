package com.nuvu.personas.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.nuvu.personas.dominio.dto.Usuario;
import com.nuvu.personas.dominio.servicio.ServicioSesion;

@Component
public class ManejadorSesion {

	private final ServicioSesion servicioSesion;

	public ManejadorSesion(ServicioSesion servicioSesion) {
		this.servicioSesion = servicioSesion;
	}
	
	public boolean validarSesion(Usuario usuario) {
		return servicioSesion.validarSesion(usuario);
	}	
}
