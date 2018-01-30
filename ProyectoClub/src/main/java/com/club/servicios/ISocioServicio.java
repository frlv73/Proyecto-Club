package com.club.servicios;

import com.club.entidades.Socio;

public interface ISocioServicio {

	boolean estaHabilitado(int id);

	void registrar(Socio socio);

	

}
