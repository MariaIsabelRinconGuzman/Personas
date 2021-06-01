package com.nuvu.personas.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nuvu.personas.dominio.adaptador.dao.DaoPersonaMySql;
import com.nuvu.personas.dominio.adaptador.repositorio.RepositorioPersonaMySql;
import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.dominio.servicio.ServicioCrearPersona;

public class ServicioCrearPersonaTest {

	private DaoPersonaMySql daoPersonaMySql;
	private RepositorioPersonaMySql repositorioPersonaMySql;
	private ServicioCrearPersona servicioCrearPersona;
	
	@BeforeEach
	public void configurar() {
		daoPersonaMySql = Mockito.mock(DaoPersonaMySql.class);
		repositorioPersonaMySql = Mockito.mock(RepositorioPersonaMySql.class);
		servicioCrearPersona = new ServicioCrearPersona(repositorioPersonaMySql);
	}
	
	@Test
	public void crearExitoso() {
		Persona persona = new Persona(10369157L, "5573735378");
		Mockito.when(daoPersonaMySql.consultar(Mockito.anyLong())).thenReturn(persona);
		servicioCrearPersona.crear(persona);
		Assertions.assertEquals(persona.getTarjetaCredito(), "5573735378");
	}	
}
