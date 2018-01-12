package com.club.entidades;

import java.util.Date;

public class DescuentoGrupoFamiliar {

	private int id_dto_gpo;
	private double valor_dto_gpo;
	private Date fecha_validez;
	
	public int getId_dto_gpo() {
		return id_dto_gpo;
	}
	public void setId_dto_gpo(int id_dto_gpo) {
		this.id_dto_gpo = id_dto_gpo;
	}
	public double getValor_dto_gpo() {
		return valor_dto_gpo;
	}
	public void setValor_dto_gpo(double valor_dto_gpo) {
		this.valor_dto_gpo = valor_dto_gpo;
	}
	public Date getFecha_validez() {
		return fecha_validez;
	}
	public void setFecha_validez(Date fecha_validez) {
		this.fecha_validez = fecha_validez;
	}
	
	
}
