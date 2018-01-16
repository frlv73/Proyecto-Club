package com.club.entidades;

public class Socio {

	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
	private String usuario;
	private String password;
	private String estado;
	private CategoriaSocio categoriaSocio;

	
	//Contructor para Login
	public Socio(String email, String pass) {
		super();
		this.setEmail(email);
		this.setPassword(pass);
	}

	public Socio() {
		super();
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

}
