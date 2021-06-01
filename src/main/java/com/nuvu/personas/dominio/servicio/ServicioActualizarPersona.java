package com.nuvu.personas.dominio.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.nuvu.personas.dominio.adaptador.dao.DaoPersonaMySql;
import com.nuvu.personas.dominio.adaptador.repositorio.RepositorioPersonaMySql;
import com.nuvu.personas.dominio.dto.Persona;

public class ServicioActualizarPersona {

	private final RepositorioPersonaMySql repositorioPersonaMySql;
	private final DaoPersonaMySql daoPersonaMySql;
	
	public ServicioActualizarPersona(RepositorioPersonaMySql repositorioPersonaMySql, DaoPersonaMySql daoPersonaMySql) {
		this.repositorioPersonaMySql = repositorioPersonaMySql;
		this.daoPersonaMySql = daoPersonaMySql;
	}

	public void actualizar(Persona persona) {
		Persona personaExiste = daoPersonaMySql.consultar(persona.getIdentificacion());
		if(null == personaExiste) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "La persona no existe");
		}
		repositorioPersonaMySql.actualizar(persona);
	}
	
}
