package com.club.datos;

import java.util.List;

import com.club.entidades.Instalacion;

public interface IInstalacionDAO {
	public List<Instalacion> getAllInstalaciones();

	public Instalacion getInstalacionPorId(int idInstalacion);

	public void actualizar(Instalacion ins);

	public void agregar(Instalacion ins);

	public void eliminar(int id);

}
