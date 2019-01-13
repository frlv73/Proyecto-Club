package com.club.entidades;

import java.util.ArrayList;
import java.util.Date;

public class CategoriaSocio { 
	private int id_categoria;
	private String descripcion;
	private String estado;
	private ArrayList<DescuentoCategoriaSocio> descuentos;

	public CategoriaSocio() {
		super();
	}
	
	public CategoriaSocio(int idCat) {
		super();
		this.setId(idCat);
	}
	
	public CategoriaSocio(int id, String descripcion,String estado) {
		super();
		this.id_categoria = id;
		this.descripcion = descripcion;
		this.estado=estado;
	}


	public int getId() {
		return id_categoria;
	}

	public void setId(int id) {
		this.id_categoria = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
	}

	public String getEstado() {
		return estado;
	}

	public ArrayList<DescuentoCategoriaSocio> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(ArrayList<DescuentoCategoriaSocio> descuentos) {
		this.descuentos = descuentos;
	}

}
