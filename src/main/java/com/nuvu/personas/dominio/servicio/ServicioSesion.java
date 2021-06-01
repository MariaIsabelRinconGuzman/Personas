package com.nuvu.personas.dominio.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.nuvu.personas.dominio.adaptador.dao.DaoUsuarioMySql;
import com.nuvu.personas.dominio.dto.Usuario;

public class ServicioSesion {
	
	private final DaoUsuarioMySql daoUsuarioMySql;
	
	public ServicioSesion(DaoUsuarioMySql daoUsuarioMySql) {
		this.daoUsuarioMySql = daoUsuarioMySql;
	}

	public boolean validarSesion(Usuario usuario) {
		boolean sesionValida = daoUsuarioMySql.validarSesion(usuario);
		if(!sesionValida) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Credenciales incorrectas");
		}
		return sesionValida;
	}
}
