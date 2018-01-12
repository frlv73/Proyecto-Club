package com.club.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Instalacion {
	
	private int id_instalacion;
	private String desc_instalacion;
	private String estado;
	private Date fecha_baja;
	private ArrayList<Adicional> adicionales;
	
	
	public int getId_instalacion() {
		return id_instalacion;
	}
	public void setId_instalacion(int id_instalacion) {
		this.id_instalacion = id_instalacion;
	}
	public String getDesc_instalacion() {
		return desc_instalacion;
	}
	public void setDesc_instalacion(String desc_instalacion) {
		this.desc_instalacion = desc_instalacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public ArrayList<Adicional> getAdicionales() {
		return adicionales;
	}
	public void setAdicionales(ArrayList<Adicional> adicionales) {
		this.adicionales = adicionales;
	}
	

}
