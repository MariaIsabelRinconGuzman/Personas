package com.nuvu.personas.dominio.servicio;

import com.nuvu.personas.dominio.adaptador.repositorio.RepositorioPersonaMySql;
import com.nuvu.personas.dominio.dto.Persona;

public class ServicioCrearPersona {

	private final RepositorioPersonaMySql repositorioPersonaMySql;

	public ServicioCrearPersona(RepositorioPersonaMySql repositorioPersonaMySql) {
		this.repositorioPersonaMySql = repositorioPersonaMySql;
	}
	
	public void crear(Persona persona) {
		repositorioPersonaMySql.insertar(persona);
	}	
}
