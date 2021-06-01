package com.nuvu.personas.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nuvu.personas.dominio.adaptador.dao.DaoPersonaMySql;
import com.nuvu.personas.dominio.adaptador.dao.DaoUsuarioMySql;
import com.nuvu.personas.dominio.adaptador.repositorio.RepositorioPersonaMySql;
import com.nuvu.personas.dominio.servicio.ServicioActualizarPersona;
import com.nuvu.personas.dominio.servicio.ServicioConsultarPersona;
import com.nuvu.personas.dominio.servicio.ServicioCrearPersona;
import com.nuvu.personas.dominio.servicio.ServicioSesion;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioActualizarPersona servicioActualizarPersona(RepositorioPersonaMySql repositorioPersonaMySql, DaoPersonaMySql daoPersonaMySql) {
		return new ServicioActualizarPersona(repositorioPersonaMySql, daoPersonaMySql);
	}
	
	@Bean
	public ServicioConsultarPersona servicioConsultarPersona(DaoPersonaMySql daoPersonaMySql) {
		return new ServicioConsultarPersona(daoPersonaMySql);
	}
	
	@Bean
	public ServicioCrearPersona servicioCrearPersona(RepositorioPersonaMySql repositorioPersonaMySql) {
		return new ServicioCrearPersona(repositorioPersonaMySql);
	}
	
	@Bean
	public ServicioSesion servicioSesion(DaoUsuarioMySql daoUsuarioMySql) {
		return new ServicioSesion(daoUsuarioMySql);
	}
}
