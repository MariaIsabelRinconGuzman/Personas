package com.nuvu.personas.dominio.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.infraestructura.adaptador.repositorio.entidad.PersonaEntidad;
import com.nuvu.personas.infraestructura.jpa.RepositorioPersonaJPA;

@Repository
public class RepositorioPersonaMySql {

	private final RepositorioPersonaJPA repositorioPersonaJPA;
    private ModelMapper modelMapper = new ModelMapper();
    
	public RepositorioPersonaMySql(RepositorioPersonaJPA repositorioPersonaJPA) {
		this.repositorioPersonaJPA = repositorioPersonaJPA;
	}
    
	public void insertar(Persona persona) {
		PersonaEntidad personaEntidad = modelMapper.map(persona, PersonaEntidad.class);
		repositorioPersonaJPA.save(personaEntidad);
	}
	
	public void actualizar(Persona persona) {
		repositorioPersonaJPA.actualizar(persona.getIdentificacion(), persona.getTarjetaCredito());
	}    
}
