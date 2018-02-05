package com.club.datos;

import java.util.List;

import com.club.entidades.Socio;

public interface ISocioDAO {

	Socio login(String email, String pass);

	void registrar(Socio socio);

	List<Socio> getAllSocios();

}
