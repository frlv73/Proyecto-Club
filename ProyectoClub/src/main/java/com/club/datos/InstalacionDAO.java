package com.club.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.club.entidades.Instalacion;

@Repository
public class InstalacionDAO implements IInstalacionDAO{
	
	// Definición de consultas a la BD
	private static String SQL_BUSCAR_TODAS = "SELECT * FROM instalaciones";

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public List<Instalacion> getAllInstalaciones() {
		List<Instalacion> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODAS, getSqlParameterByModel(null), new InstalacionMapper());
		return lista;
	}
	
	private SqlParameterSource getSqlParameterByModel(Instalacion instalacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (instalacion != null) {
			paramSource.addValue("id", instalacion.getId());
			paramSource.addValue("descripcion", instalacion.getDescripcion());
			paramSource.addValue("fecha_baja", instalacion.getFechaBaja());
		}
		return paramSource;
	}

	private static final class InstalacionMapper implements RowMapper<Instalacion> {

		@Override
		public Instalacion mapRow(ResultSet rs, int numFilas) throws SQLException {
			Instalacion ins = new Instalacion();
			ins.setId(rs.getInt("id_instalacion"));
			ins.setDescripcion(rs.getString("descripcion"));
			ins.setFechaBaja(rs.getDate("fecha_baja"));
			return ins;
		}

	}

}
