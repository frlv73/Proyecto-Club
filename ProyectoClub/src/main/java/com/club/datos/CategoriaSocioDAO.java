package com.club.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.club.entidades.CategoriaSocio;

@Repository
public class CategoriaSocioDAO implements ICategoriaSocioDAO {

	// Definición de consultas a la BD
	private static String SQL_BUSCAR_TODAS = "SELECT * FROM categorias";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM categorias WHERE id_categoria = :id";
	private static String SQL_INSERTAR = "INSERT INTO categorias (descripcion) VALUES (:descripcion)";
	private static String SQL_ACTUALIZAR = "UPDATE categorias SET descripcion = :descripcion WHERE id_categoria = :id";

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public List<CategoriaSocio> getAllCategorias() {
		List<CategoriaSocio> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODAS, getSqlParameterByModel(null),
				new CategoriaMapper());
		return lista;
	}

	@Override
	public CategoriaSocio getCategoriaPorId(int idCategoria) {
		CategoriaSocio categoria = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_ID, getSqlParameterByModel(new CategoriaSocio(idCategoria)), new CategoriaMapper());
		return categoria;

	}
	
	
	@Override
	public void actualizar(CategoriaSocio cat) {
		namedParameterJdbcTemplate.update(SQL_ACTUALIZAR, getSqlParameterByModel(cat));
		
	}
	
	@Override
	public void agregar(CategoriaSocio cat) {
		namedParameterJdbcTemplate.update(SQL_INSERTAR, getSqlParameterByModel(cat));
		
	}
	
	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private SqlParameterSource getSqlParameterByModel(CategoriaSocio categoriaSocio) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (categoriaSocio != null) {
			paramSource.addValue("id", categoriaSocio.getId());
			paramSource.addValue("descripcion", categoriaSocio.getDescripcion());
			
		}
		return paramSource;
	}

	private static final class CategoriaMapper implements RowMapper<CategoriaSocio> {

		@Override
		public CategoriaSocio mapRow(ResultSet rs, int numFilas) throws SQLException {
			CategoriaSocio cat = new CategoriaSocio();
			cat.setId(rs.getInt("id_categoria"));
			cat.setDescripcion(rs.getString("descripcion"));
			
			return cat;
		}

	}



}
