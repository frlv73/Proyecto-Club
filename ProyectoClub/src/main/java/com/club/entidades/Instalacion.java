package com.club.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Instalacion {

	private int id;
	private String descripcion;
	private String estado;
	private Date fechaBaja;
	private ArrayList<Adicional> adicionales;
	
	public Instalacion() {
		super();
	}

	public Instalacion(int idInstalacion) {
		super();
		this.setId(idInstalacion);
	}

	public Instalacion(int id, String descripcion, String estado, Date fecha_baja, ArrayList<Adicional> adicionales) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaBaja = fecha_baja;
		this.adicionales = adicionales;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public ArrayList<Adicional> getAdicionales() {
		return adicionales;
	}

	public void setAdicionales(ArrayList<Adicional> adicionales) {
		this.adicionales = adicionales;
	}

}
