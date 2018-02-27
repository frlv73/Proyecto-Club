package com.club.entidades;

import java.util.Date;

public class Reserva {
	
	private int id;
	private Socio socio;
	private Instalacion instalacion;
	private Date fechaReserva;
	private int duracion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Instalacion getInstalacion() {
		return instalacion;
	}
	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
