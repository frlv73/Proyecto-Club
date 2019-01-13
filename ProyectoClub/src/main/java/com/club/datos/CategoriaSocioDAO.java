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
	private static String SQL_BUSCAR_TODAS = "SELECT * FROM categorias where fecha_baja is null or estado='Habilitada'";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM categorias WHERE id_categoria = :id_categoria";
	private static String SQL_INSERTAR = "INSERT INTO categorias (descripcion,estado) VALUES (:descripcion,'Habilitada')";
	private static String SQL_ACTUALIZAR = "UPDATE categorias SET descripcion = :descripcion, estado=:estado WHERE id_categoria = :id_categoria";
	private static String SQL_ELIMINAR="update categorias set fecha_baja=current_date(), estado='Deshabilitada' where id_categoria= :id_categoria";

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
		CategoriaSocio categoria = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_ID,
				getSqlParameterByModel(new CategoriaSocio(idCategoria)), new CategoriaMapper());
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
		namedParameterJdbcTemplate.update(SQL_ELIMINAR, getSqlParameterByModel(getCategoriaPorId(id)));
		
		
	}
	
	
	
	private SqlParameterSource getSqlParameterByModel(CategoriaSocio categoriaSocio) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (categoriaSocio != null) {
			paramSource.addValue("id_categoria", categoriaSocio.getId());
			paramSource.addValue("descripcion", categoriaSocio.getDescripcion());
			paramSource.addValue("estado", categoriaSocio.getEstado());
			
		}
		return paramSource;
	}

	private static final class CategoriaMapper implements RowMapper<CategoriaSocio> {

		@Override
		public CategoriaSocio mapRow(ResultSet rs, int numFilas) throws SQLException {
			CategoriaSocio cat = new CategoriaSocio();
			cat.setId(rs.getInt("id_categoria"));
			cat.setDescripcion(rs.getString("descripcion"));
			cat.setEstado(rs.getString("estado"));
			
			return cat;
		}

	}



}
