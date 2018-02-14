package com.club.servicios;

import java.util.List;

import com.club.entidades.Actividad;

public interface IActividadServicio {
	
	public List<Actividad> getAllActividades();

	public Actividad getActividadPorId(int idActividad);

	public void actualizar(Actividad act);

	public void agregar(Actividad act);

	public void eliminar(int id);

}
