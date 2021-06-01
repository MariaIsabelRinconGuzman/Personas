package com.nuvu.personas.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import com.nuvu.personas.dominio.adaptador.dao.DaoPersonaMySql;
import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.dominio.servicio.ServicioConsultarPersona;

public class ServicioConsultarPersonaTest {
	
	private DaoPersonaMySql daoPersonaMySql;
	public ServicioConsultarPersona servicioConsultarPersona;
	
	@BeforeEach
	public void configurar() {
		daoPersonaMySql = Mockito.mock(DaoPersonaMySql.class);
		servicioConsultarPersona = new ServicioConsultarPersona(daoPersonaMySql);
	}
	
	@Test
	public void consultarExitoso() {
		Persona personaMock = new Persona(10369L, "4256786");
		Mockito.when(daoPersonaMySql.consultar(Mockito.anyLong())).thenReturn(personaMock);
		Persona persona = servicioConsultarPersona.consultar(10369L);
		Assertions.assertEquals(persona.getTarjetaCredito(), "4256786");
	}
	
	@Test
	public void consultarFallido() {
		Mockito.when(daoPersonaMySql.consultar(Mockito.anyLong())).thenReturn(null);
		ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
			servicioConsultarPersona.consultar(1L);
        });
		Assertions.assertEquals("403 FORBIDDEN \"La persona no existe\"", exception.getMessage());	
	}
}
