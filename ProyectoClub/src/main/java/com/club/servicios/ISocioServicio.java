package com.club.servicios;

import java.util.List;

import com.club.entidades.Instalacion;
import com.club.entidades.Socio;

public interface ISocioServicio {

	boolean estaHabilitado(int id);
	
	public Socio getSocioPorId(int idSocio);

	void registrar(Socio socio);

	public List<Socio> getAllSocios();
	
	public void actualizar(Socio socio);

	public void agregar(Socio socio);

	public void eliminar(int id);

	public List<Socio> getAllSociosConReservas();

	

}
