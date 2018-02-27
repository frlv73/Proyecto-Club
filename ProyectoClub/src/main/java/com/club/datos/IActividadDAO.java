package com.club.datos;

import java.util.List;

import com.club.entidades.Actividad;

public interface IActividadDAO {
	public List<Actividad> getAllActividades();
	public Actividad getActividadPorId(int idActividad);
	public void actualizar(Actividad act);
	public void agregar(Actividad act);
	public List<Actividad> getActidadesConInscriptos();

}
