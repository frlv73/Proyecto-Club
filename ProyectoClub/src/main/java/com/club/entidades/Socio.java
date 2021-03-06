package com.club.entidades;

import java.sql.Date;
import java.util.List;

public class Socio {

	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String localidad;
	private String telefono;
	private String email;
	private String usuario;
	private String password;
	private String estado;
	private Date fecha_baja;
	private CategoriaSocio categoriaSocio;
	private List<Reserva> reservasRealizadas;
	private int id_cat_soc;

	
	//Contructor para Login
	public Socio(String email, String pass) {
		super();
		this.setEmail(email);
		this.setPassword(pass);
	}

	public Socio() {
		super();
	}

	public Socio(int idSocio) {
		super();
		this.setId(idSocio);
	}
	public Socio(int id,String d, String nombre, String apellido, String loc, String dir, String tel, int cat, String m, String contras) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(d);
		this.setLocalidad(loc);
		this.setDireccion(dir);
		this.setTelefono(tel);
		this.setIdCat(cat);
		this.setEmail(m);
		this.setPassword(contras);
	}

	public int getIdCat() {
		return id_cat_soc;
	}
	
	public void setIdCat(int id) {
		this.id_cat_soc=id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CategoriaSocio getCategoriaSocio() {
		return categoriaSocio;
	}

	public void setCategoriaSocio(CategoriaSocio categoriaSocio) {
		this.categoriaSocio = categoriaSocio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public Date getFechaBaja() {
		return fecha_baja;
	}
	
	public void setFechaBaja(Date fecha) {
		this.fecha_baja=fecha;
	}

	public List<Reserva> getReservasRealizadas() {
		return reservasRealizadas;
	}

	public void setReservasRealizadas(List<Reserva> reservasRealizadas) {
		this.reservasRealizadas = reservasRealizadas;
	}

}
