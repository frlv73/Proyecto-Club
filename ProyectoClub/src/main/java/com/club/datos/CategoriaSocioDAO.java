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

	private SqlParameterSource getSqlParameterByModel(CategoriaSocio categoriaSocio) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (categoriaSocio != null) {
			paramSource.addValue("id", categoriaSocio.getId());
			paramSource.addValue("descripcion", categoriaSocio.getDescripcion());
			paramSource.addValue("fecha_baja", categoriaSocio.getFechaBaja());
		}
		return paramSource;
	}

	private static final class CategoriaMapper implements RowMapper<CategoriaSocio> {

		@Override
		public CategoriaSocio mapRow(ResultSet rs, int numFilas) throws SQLException {
			CategoriaSocio cat = new CategoriaSocio();
			cat.setId(rs.getInt("id_categoria"));
			cat.setDescripcion(rs.getString("descripcion"));
			cat.setFechaBaja(rs.getDate("fecha_baja"));
			return cat;
		}

	}

}
