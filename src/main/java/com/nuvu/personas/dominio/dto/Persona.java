package com.nuvu.personas.dominio.dto;

public class Persona {
	
	private Long identificacion;
	private String tarjetaCredito;
	
	public Persona() {
	}
	
	public Persona(Long identificacion, String tarjetaCredito) {
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
