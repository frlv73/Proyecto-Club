package com.club.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.club.entidades.Actividad;
import com.club.entidades.CategoriaSocio;
import com.club.entidades.Inscripcion;
import com.club.entidades.Instalacion;
import com.club.entidades.Reserva;
import com.club.entidades.Socio;

@Repository
public class ActividadDAO implements IActividadDAO{
	

	// Definición de consultas a la BD
	private static String SQL_BUSCAR_TODAS = "SELECT * FROM actividades where fecha_baja is null or estado='Activa'";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM actividades WHERE id_actividad = :id";
	private static String SQL_INSERTAR = "INSERT INTO actividades (descripcion, estado, costo) VALUES (:descripcion,'Activa', :costo)";
	private static String SQL_ACTUALIZAR = "UPDATE actividades SET descripcion = :descripcion, costo = :costo WHERE id_actividad = :id";
	private static String SQL_BUSCAR_TODAS_ACTIVIDADES_CON_INSCRIPTOS = "SELECT act.id_actividad, act.descripcion, soc.id_socio, soc.nombre, soc.apellido, ins.id_inscripcion FROM actividades act INNER JOIN inscripciones ins on act.id_actividad = ins.id_actividad\r\n" + 
			"INNER JOIN socios soc on ins.id_socio = soc.id_socio;";
	private static String SQL_ELIMINAR="update actividades set fecha_baja=current_date(),estado='Inactiva' where id_actividad=:id";
	
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
	
	@Override
	public void eliminar(int id) {
		namedParameterJdbcTemplate.update(SQL_ELIMINAR, getSqlParameterByModel(getActividadPorId(id)));
		
	}
	
	@Override
	public List<Actividad> getActidadesConInscriptos() {
		return namedParameterJdbcTemplate.query(SQL_BUSCAR_TODAS_ACTIVIDADES_CON_INSCRIPTOS, getSqlParameterByModel(null), new ActividadExtractor());
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Actividad actividad) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (actividad != null) {
			paramSource.addValue("id", actividad.getId());
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
			act.setId(rs.getInt("id_actividad"));
			act.setDescripcion(rs.getString("descripcion"));
			act.setCosto(rs.getDouble("costo"));
			act.setEstado(rs.getString("estado"));
			
			return act;
		}

	}

	private static final class ActividadExtractor implements ResultSetExtractor<List<Actividad>> {

		@Override
		public List<Actividad> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Actividad> map = new HashMap<Integer, Actividad>();

			while (rs.next()) {
				int id = rs.getInt("id_actividad");
				Actividad actividad = map.get(id);
				if (null == actividad) {
					actividad = new Actividad();
					actividad.setDescripcion(rs.getString("descripcion"));
					actividad.setId(rs.getInt("id_actividad"));
					map.put(id, actividad);
				}

				List<Inscripcion> listaInscripciones = actividad.getInscripciones();
				if (null == listaInscripciones) {
					listaInscripciones = new ArrayList<Inscripcion>();
					actividad.setInscripciones(listaInscripciones);
				}

				Inscripcion ins = new Inscripcion();
				ins.setId(rs.getInt("id_inscripcion"));
				ins.setActividad(new Actividad(actividad.getId()));
				//ins.setSocio(new Socio(rs.getInt("id_socio"), rs.getString("nombre"), rs.getString("apellido"),rs.getString("dni")));
				listaInscripciones.add(ins);
				
			}
			return new ArrayList<Actividad>(map.values());
		}

	}
	

}
