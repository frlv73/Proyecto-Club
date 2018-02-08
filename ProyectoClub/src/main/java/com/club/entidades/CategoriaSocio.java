package com.club.entidades;

import java.util.ArrayList;
import java.util.Date;

public class CategoriaSocio { 
	private int id;
	private String descripcion;
	private ArrayList<DescuentoCategoriaSocio> descuentos;

	public CategoriaSocio(int id) {
		super();
		this.setId(id);
	}
	
	
	public CategoriaSocio(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public CategoriaSocio() {
		super();
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


	public ArrayList<DescuentoCategoriaSocio> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(ArrayList<DescuentoCategoriaSocio> descuentos) {
		this.descuentos = descuentos;
	}

}
