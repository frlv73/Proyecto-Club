package com.club.entidades;

import java.util.Date;

public class RecargoPorMora {
	
	private int id_recargo;
	private double valor_recargo;
	private Date fecha_validez;

	public int getId_recargo() {
		return id_recargo;
	}
	public void setId_recargo(int id_recargo) {
		this.id_recargo = id_recargo;
	}
	public double getValor_recargo() {
		return valor_recargo;
	}
	public void setValor_recargo(double valor_recargo) {
		this.valor_recargo = valor_recargo;
	}
	public Date getFecha_validez() {
		return fecha_validez;
	}
	public void setFecha_validez(Date fecha_validez) {
		this.fecha_validez = fecha_validez;
	}
	
}
