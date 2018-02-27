package com.club.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.datos.ISocioDAO;
import com.club.entidades.CategoriaSocio;
import com.club.entidades.Socio;

@Service
public class SocioServicio implements ISocioServicio{
	
	@Autowired
	private ISocioDAO dao;

	@Override
	public boolean estaHabilitado(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void registrar(Socio socio) {		
		//El nuevo socio estará habilitado y será de categoría activo
		socio.setEstado("Habilitado");
		socio.setCategoriaSocio(new CategoriaSocio(1));
		dao.registrar(socio);
		
	}

	@Override
	public List<Socio> getAllSocios() {
		return dao.getAllSocios();
	}

	@Override
	public void actualizar(Socio socio) {
		dao.actualizar(socio);
		
	}

	@Override
	public void agregar(Socio socio) {
		dao.agregar(socio);
		
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
		
	}

	@Override
	public Socio getSocioPorId(int idSocio) {
		// TODO Auto-generated method stub
		return dao.getSocioPorId(idSocio);
	}

	@Override
	public List<Socio> getAllSociosConReservas() {
		return dao.getAllSociosConReservas();
	}

}
