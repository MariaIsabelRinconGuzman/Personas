package com.nuvu.personas.infraestructura.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nuvu.personas.infraestructura.adaptador.repositorio.entidad.PersonaEntidad;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepositorioPersonaJPA extends JpaRepository<PersonaEntidad, Serializable>{

	@Transactional(readOnly=false)
	@Modifying
	@Query("update PersonaEntidad p set p.tarjetaCredito = :tarjetaCredito WHERE p.identificacion = :identificacion")
	void actualizar(@Param(value = "identificacion") Long identificacion, @Param(value = "tarjetaCredito") String tarjetaCredito);

	@Query("select p from PersonaEntidad p where p.identificacion = :identificacion")
	Optional<PersonaEntidad> buscarPorId(@Param("identificacion") Long identificacion);
	
}
