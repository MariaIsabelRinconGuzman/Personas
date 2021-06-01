package com.nuvu.personas.dominio.adaptador.dao;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.infraestructura.adaptador.repositorio.entidad.PersonaEntidad;
import com.nuvu.personas.infraestructura.jpa.RepositorioPersonaJPA;

@Repository
public class DaoPersonaMySql {

	private final RepositorioPersonaJPA repositorioPersonaJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public DaoPersonaMySql(RepositorioPersonaJPA repositorioPersonaJPA) {
		this.repositorioPersonaJPA = repositorioPersonaJPA;
	}

	public Persona consultar(Long identificacion) {
		Optional<PersonaEntidad> personaEntidad = repositorioPersonaJPA.findById(identificacion);
		if (!personaEntidad.isPresent()) {
			return null;
		}
		return modelMapper.map(personaEntidad.get(), Persona.class);
	}
}
