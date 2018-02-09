package com.club.datos;

import java.util.List;

import com.club.entidades.Instalacion;
import com.club.entidades.Socio;

public interface ISocioDAO {

	Socio login(String email, String pass);

	void registrar(Socio socio);

	public List<Socio> getAllSocios();
	public Socio getSocioPorId(int id);

	public void actualizar(Socio soc);

	public void agregar(Socio soc);

	public void eliminar(int id);


}
