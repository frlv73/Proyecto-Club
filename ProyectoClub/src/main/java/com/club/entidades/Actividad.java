package com.club.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
	
private int id;
private String descripcion;
private String estado;
private double costo;
private ArrayList<HorariosActividades> horarios;
private List<Inscripcion> inscripciones;
private Date fecha_baja;

public Date getFechaBaja() {
	return fecha_baja;
}

public void setFechaBaja(Date fecha) {
	this.fecha_baja=fecha;
}
public ArrayList<HorariosActividades> getHorarios() {
	return horarios;
}
public void setHorarios(ArrayList<HorariosActividades> horarios) {
	this.horarios = horarios;
}
public int getId() {
	return id;
}
public void setId(int id_actividad) {
	this.id = id_actividad;
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
public double getCosto() {
	return costo;
}
public void setCosto(double costo) {
	this.costo = costo;
}

public Actividad(int id, String desc,String est, double costo){
	this.setId(id);
	this.setDescripcion(desc);
	this.setEstado(est);
	this.setCosto(costo);                                                                                                               
}

public Actividad(){}


public Actividad(int id_actividad) {
	super();
	this.id = id_actividad;
}
public List<Inscripcion> getInscripciones() {
	return inscripciones;
}
public void setInscripciones(List<Inscripcion> inscripciones) {
	this.inscripciones = inscripciones;
}


}
