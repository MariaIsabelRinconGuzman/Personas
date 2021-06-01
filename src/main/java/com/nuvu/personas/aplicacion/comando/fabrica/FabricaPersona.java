package com.nuvu.personas.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.nuvu.personas.aplicacion.comando.ComandoPersona;
import com.nuvu.personas.dominio.dto.Persona;

@Component
public class FabricaPersona {

	public Persona crear(ComandoPersona comandoPersona) {
		return new Persona(comandoPersona.getIdentificacion(), comandoPersona.getTarjetaCredito());		
	}	
}
