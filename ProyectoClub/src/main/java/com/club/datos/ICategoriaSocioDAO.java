package com.club.datos;

import java.util.List;

import com.club.entidades.CategoriaSocio;

public interface ICategoriaSocioDAO {
	public List<CategoriaSocio> getAllCategorias();

	public CategoriaSocio getCategoriaPorId(int idCategoria);

	public void actualizar(CategoriaSocio cat);

	public void agregar(CategoriaSocio cat);

	public void eliminar(int id);
}
