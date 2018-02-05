package com.club.servicios;

import java.util.List;

import com.club.entidades.Socio;

public interface ISocioServicio {

	boolean estaHabilitado(int id);

	void registrar(Socio socio);

	public List<Socio> getAllSocios();

	

}
