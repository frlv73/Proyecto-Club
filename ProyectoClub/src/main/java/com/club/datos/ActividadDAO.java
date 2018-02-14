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

import com.club.entidades.Actividad;

@Repository
public class ActividadDAO implements IActividadDAO{
	

	// Definición de consultas a la BD
	private static String SQL_BUSCAR_TODAS = "SELECT * FROM actividades";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM actividades WHERE id_actividad = :id";
	private static String SQL_INSERTAR = "INSERT INTO categorias (descripcion, costo) VALUES (:descripcion, :costo)";
	private static String SQL_ACTUALIZAR = "UPDATE actividades SET descripcion = :descripcion, costo = :costo, estado = :estado WHERE id_actividad = :id";

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public List<Actividad> getAllActividades() {
		List<Actividad> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODAS, getSqlParameterByModel(null), new ActividadMapper());
		return lista;
	}
	
	@Override
	public Actividad getActividadPorId(int idActividad) {
		Actividad actividad = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_ID, getSqlParameterByModel(new Actividad(idActividad)), new ActividadMapper());
		return actividad;

	}
	
	
	@Override
	public void actualizar(Actividad act) {
		namedParameterJdbcTemplate.update(SQL_ACTUALIZAR, getSqlParameterByModel(act));
		
	}
	
	@Override
	public void agregar(Actividad act) {
		namedParameterJdbcTemplate.update(SQL_INSERTAR, getSqlParameterByModel(act));
		
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Actividad actividad) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (actividad != null) {
			paramSource.addValue("id", actividad.getId_actividad());
			paramSource.addValue("descripcion", actividad.getDescripcion());
			paramSource.addValue("costo", actividad.getCosto());
			paramSource.addValue("estado", actividad.getEstado());
			
		}
		return paramSource;
	}

	private static final class ActividadMapper implements RowMapper<Actividad> {

		@Override
		public Actividad mapRow(ResultSet rs, int numFilas) throws SQLException {
			Actividad act = new Actividad();
			act.setId_actividad(rs.getInt("id_actividad"));
			act.setDescripcion(rs.getString("descripcion"));
			act.setCosto(rs.getDouble("costo"));
			act.setEstado(rs.getString("estado"));
			
			return act;
		}

	}
	

}
