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
public class InstalacionDAO implements IInstalacionDAO {

	// Definición de consultas a la BD
	private static String SQL_BUSCAR_TODAS = "SELECT * FROM instalaciones where fecha_baja is null or estado='Habilitada'";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM instalaciones WHERE id_instalaciones = :id";
	private static String SQL_INSERTAR = "INSERT INTO instalaciones (descripcion,estado) VALUES (:descripcion, :estado)";
	private static String SQL_ACTUALIZAR = "UPDATE instalaciones SET descripcion = :descripcion, estado = :estado WHERE id_instalaciones = :id";
	private static String SQL_ELIMINAR="update instalaciones set fecha_baja=current_date(),estado='Deshabilitada' where id_instalaciones=:id";
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public List<Instalacion> getAllInstalaciones() {
		List<Instalacion> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODAS, getSqlParameterByModel(null),
				new InstalacionMapper());
		return lista;
	}

	@Override
	public Instalacion getInstalacionPorId(int idInstalacion) {
		try {
			Instalacion instalacion = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_ID,
					getSqlParameterByModel(new Instalacion(idInstalacion)), new InstalacionMapper());
			return instalacion;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public void actualizar(Instalacion ins) {
		namedParameterJdbcTemplate.update(SQL_ACTUALIZAR, getSqlParameterByModel(ins));

	}

	@Override
	public void agregar(Instalacion ins) {
		namedParameterJdbcTemplate.update(SQL_INSERTAR, getSqlParameterByModel(ins));

	}

	@Override
	public void eliminar(int id) {
		namedParameterJdbcTemplate.update(SQL_ELIMINAR, getSqlParameterByModel(getInstalacionPorId(id)));



	}

	private SqlParameterSource getSqlParameterByModel(Instalacion instalacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (instalacion != null) {
			paramSource.addValue("id", instalacion.getId());
			paramSource.addValue("descripcion", instalacion.getDescripcion());
			//paramSource.addValue("fecha_baja", instalacion.getFechaBaja());
			paramSource.addValue("estado", instalacion.getEstado());
		}
		return paramSource;
	}

	private static final class InstalacionMapper implements RowMapper<Instalacion> {

		@Override
		public Instalacion mapRow(ResultSet rs, int numFilas) throws SQLException {
			Instalacion ins = new Instalacion();
			ins.setId(rs.getInt("id_instalaciones"));
			ins.setDescripcion(rs.getString("descripcion"));
			//ins.setFechaBaja(rs.getDate("fecha_baja"));
			ins.setEstado(rs.getString("estado"));
			return ins;
		}

	}

}
