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
	
	

}
