package com.nuvu.personas.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import com.nuvu.personas.dominio.adaptador.dao.DaoPersonaMySql;
import com.nuvu.personas.dominio.adaptador.repositorio.RepositorioPersonaMySql;
import com.nuvu.personas.dominio.dto.Persona;
import com.nuvu.personas.dominio.servicio.ServicioActualizarPersona;

public class ServicioActualizarPersonaTest {

	private RepositorioPersonaMySql repositorioPersonaMySql;
	private DaoPersonaMySql daoPersonaMySql;
	private ServicioActualizarPersona servicioActualizarPersona;
	
	@BeforeEach
	public void configurar() {
		repositorioPersonaMySql = Mockito.mock(RepositorioPersonaMySql.class);
		daoPersonaMySql = Mockito.mock(DaoPersonaMySql.class);
		servicioActualizarPersona = new ServicioActualizarPersona(repositorioPersonaMySql, daoPersonaMySql);
	}

	@Test
	public void actualizarFallido() {
		Persona personaActualizar = new Persona(1L, null);
		Mockito.when(daoPersonaMySql.consultar(Mockito.anyLong())).thenReturn(null);
		ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
			servicioActualizarPersona.actualizar(personaActualizar);
        });
		Assertions.assertEquals("403 FORBIDDEN \"La persona no existe\"", exception.getMessage());
	}
	
	@Test
	public void actualizarExitoso() {
		Persona persona = new Persona(10369157L, "5573735378");
		Mockito.when(daoPersonaMySql.consultar(Mockito.anyLong())).thenReturn(persona);
		persona.setTarjetaCredito("7888888777777");
		servicioActualizarPersona.actualizar(persona);
		Assertions.assertEquals(persona.getTarjetaCredito(), "7888888777777");
	}	
}
