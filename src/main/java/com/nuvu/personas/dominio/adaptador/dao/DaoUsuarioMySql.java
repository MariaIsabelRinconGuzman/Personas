package com.nuvu.personas.dominio.adaptador.dao;

import org.springframework.stereotype.Repository;

import com.nuvu.personas.dominio.dto.Usuario;
import com.nuvu.personas.infraestructura.adaptador.repositorio.entidad.UsuarioEntidad;
import com.nuvu.personas.infraestructura.jpa.RepositorioUsuarioJPA;

@Repository
public class DaoUsuarioMySql {

	private final RepositorioUsuarioJPA repositorioUsuarioJPA;
	
	public DaoUsuarioMySql(RepositorioUsuarioJPA repositorioUsuarioJPA) {
		this.repositorioUsuarioJPA = repositorioUsuarioJPA;
	}

	public boolean validarSesion(Usuario usuario) {	
		UsuarioEntidad usuarioEntidad = repositorioUsuarioJPA.buscarUsuarioContrasena(usuario.getUsuario(), usuario.getContrasena());
		return null != usuarioEntidad;
	}
}
