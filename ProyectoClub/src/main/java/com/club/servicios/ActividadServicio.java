package com.club.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.datos.IActividadDAO;
import com.club.entidades.Actividad;

@Service
public class ActividadServicio implements IActividadServicio{
	
	@Autowired
	private IActividadDAO dao;

	@Override
	public List<Actividad> getAllActividades() {
		
		return dao.getAllActividades();
	}

	@Override
	public Actividad getActividadPorId(int idActividad) {
	
		return dao.getActividadPorId(idActividad);
	}

	@Override
	public void actualizar(Actividad act) {
		dao.actualizar(act);
		
	}

	@Override
	public void agregar(Actividad act) {
		dao.agregar(act);
		
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
		
	}

	@Override
	public List<Actividad> getActividadesConInscriptos() {
		return dao.getActidadesConInscriptos();
	}

}
