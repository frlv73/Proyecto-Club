package com.club.servicios;

import java.util.List;

import com.club.entidades.CategoriaSocio;

public interface ICategoriaServicio {
	public List<CategoriaSocio> getAllCategorias();

	public CategoriaSocio getCategoriaPorId(int idCategoria);

	public void actualizar(CategoriaSocio cat);

	public void agregar(CategoriaSocio cat);

	public void eliminar(int id);

}
