package com.club.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.datos.IInstalacionDAO;
import com.club.entidades.Instalacion;

@Service
public class InstalacionServicio implements IInstalacionServicio{
	
	@Autowired
	private IInstalacionDAO dao;

	@Override
	public List<Instalacion> getAllInstalaciones() {
		return dao.getAllInstalaciones();
	}

	@Override
	public Instalacion getInstalacionPorId(int idInstalacion) {
		
		return dao.getInstalacionPorId(idInstalacion);
	}

	@Override
	public void actualizar(Instalacion ins) {
		dao.actualizar(ins);
		
	}

	@Override
	public void agregar(Instalacion ins) {
		dao.agregar(ins);
		
	}
	
	

}
