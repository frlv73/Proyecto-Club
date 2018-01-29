package com.club.servicios;

import java.util.List;

import com.club.entidades.Instalacion;

public interface IInstalacionServicio {

	public List<Instalacion> getAllInstalaciones();

	public Instalacion getInstalacionPorId(int idInstalacion);

	public void actualizar(Instalacion ins);

	public void agregar(Instalacion ins);
}
