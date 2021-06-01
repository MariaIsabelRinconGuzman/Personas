package com.nuvu.personas.dominio.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.nuvu.personas.dominio.adaptador.dao.DaoPersonaMySql;
import com.nuvu.personas.dominio.dto.Persona;

public class ServicioConsultarPersona {
	
	private final DaoPersonaMySql daoPersonaMySql;

	public ServicioConsultarPersona(DaoPersonaMySql daoPersonaMySql) {
		this.daoPersonaMySql = daoPersonaMySql;
	}
	
	public Persona consultar(Long identificacion) {
		Persona persona = daoPersonaMySql.consultar(identificacion);
		if(null == persona) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "La persona no existe");
		}
		return persona;
	}
}
