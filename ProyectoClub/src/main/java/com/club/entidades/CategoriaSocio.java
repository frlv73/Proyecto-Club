package com.club.entidades;

import java.util.ArrayList;
import java.util.Date;

public class CategoriaSocio {
	private int id;
	private String descripcion;
	private Date fechaBaja;
	private ArrayList<DescuentoCategoriaSocio> descuentos;

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

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public ArrayList<DescuentoCategoriaSocio> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(ArrayList<DescuentoCategoriaSocio> descuentos) {
		this.descuentos = descuentos;
	}

}
