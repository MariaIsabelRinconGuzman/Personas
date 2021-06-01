package com.nuvu.personas.infraestructura.adaptador.repositorio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class PersonaEntidad{

	@Id
	private Long identificacion;
	
	@Column
	private String tarjetaCredito;
	

	public PersonaEntidad() {
	}		

	public PersonaEntidad(Long identificacion, String tarjetaCredito) {
		this.identificacion = identificacion;
		this.tarjetaCredito = tarjetaCredito;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
}
