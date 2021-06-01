package com.nuvu.personas.infraestructura.jpa;

import org.springframework.stereotype.Repository;

import com.nuvu.personas.infraestructura.adaptador.repositorio.entidad.UsuarioEntidad;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepositorioUsuarioJPA extends JpaRepository<UsuarioEntidad, Serializable>{

	@Query("select u from UsuarioEntidad u where u.usuario = :usuario and u.contrasena = :contrasena")
	UsuarioEntidad buscarUsuarioContrasena(@Param(value = "usuario") String usuario, @Param(value = "contrasena") String contrasena);
}
