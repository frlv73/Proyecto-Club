package com.club.entidades;

import java.sql.Date;

// Enumeración para usar a futuro. Las categorías de socio y los estados son valores finitos que no deberían ser modificados.
// TO DO: Averiguar cómo trabajan enums en BD
public enum Categoria {
	ACTIVO(1), CADETE(2), MENOR(3), INFANTE(4), LICENCIA_ACTIVO(5), DEPORTIVO(6), JUBILADO(8), BECADO(9);

	private int id;
	private String desc;
	private Date fechaBaja;
	private String estado;
	
	private Categoria(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setFechaBaja(Date fecha) {
		this.fechaBaja=fecha;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setEstado(String estado) {
		this.estado=estado;
	}
	public String getEstado() {
		return estado;
	}

}
