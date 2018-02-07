package com.club.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.datos.ICategoriaSocioDAO;
import com.club.entidades.CategoriaSocio;

@Service
public class CategoriaServicio implements ICategoriaServicio{
	
	@Autowired
	private ICategoriaSocioDAO dao;

	@Override
	public List<CategoriaSocio> getAllCategorias() {
		
		return dao.getAllCategorias();
	}

	@Override
	public CategoriaSocio getCategoriaPorId(int idCategoria) {
		return dao.getCategoriaPorId(idCategoria);
	}

	@Override
	public void actualizar(CategoriaSocio cat) {
		dao.actualizar(cat);
		
	}

	@Override
	public void agregar(CategoriaSocio cat) {
		dao.agregar(cat);
		
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
		
	}

}
