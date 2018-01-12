package com.club.entidades;

import java.util.Date;

public class Empleado {
	
	private int id_empleado;
	private String nombre;
	private String apellido;
	private String mail;
	private String usuario;
	private String password;
	private Date fecha_baja;
	
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	
	public Empleado(String n, String a, String m, String u, String p){
		this.setApellido(a);
		this.setNombre(n);
		this.setMail(m);
		this.setUsuario(u);
		this.setPassword(p);
		
	}

}
