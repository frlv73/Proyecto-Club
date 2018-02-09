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

import com.club.entidades.CategoriaSocio;
import com.club.entidades.Socio;

@Repository
public class SocioDAO implements ISocioDAO {

	private static String SQL_BUSCAR_TODOS = "Select * from Socios";
	private static String SQL_BUSCAR_POR_ID = "SELECT * FROM Socios WHERE id_socio = :id";
	private static String SQL_LOGIN = "SELECT * FROM socios WHERE mail= :email AND password= :password";
	private static String SQL_INSERTAR = "INSERT INTO socios (dni, nombre, apellido, localidad, direccion, telefono, "
			                           + "mail, password, estado, id_categoria_socio) VALUES (:dni, :nombre, :apellido, :localidad, :direccion,"
			                           + ":telefono, :email, :password, :estado, :id_categoria)";
	private static String SQL_ACTUALIZAR = "UPDATE socios SET dni = :dni, nombre = :nombre, apellido = :apellido, direccion = :direccion, telefono = :telefono, estado = :estado,"
									+ ", id_categoria_socio = :id_cat_soc WHERE id_socio = :id";

	

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public Socio login(String email, String pass) {
		Socio socio = namedParameterJdbcTemplate.queryForObject(SQL_LOGIN,
				getSqlParameterByModel(new Socio(email, pass)), new SocioMapper());
		return socio;
	}

	@Override
	public void registrar(Socio socio) {
		namedParameterJdbcTemplate.update(SQL_INSERTAR, getSqlParameterByModel(socio));

	}

	// Setea los parámetros a enviar en la consulta a la base de datos
	private SqlParameterSource getSqlParameterByModel(Socio socio) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (socio != null) {
			paramSource.addValue("id_socio", socio.getId());
			paramSource.addValue("dni", socio.getDni());
			paramSource.addValue("nombre", socio.getNombre());
			paramSource.addValue("apellido", socio.getApellido());
			paramSource.addValue("email", socio.getEmail());
			paramSource.addValue("password", socio.getPassword());
			paramSource.addValue("localidad", socio.getLocalidad());
			paramSource.addValue("direccion", socio.getDireccion());
			paramSource.addValue("telefono", socio.getTelefono());
			// Si no tenemos definida la categoría del socio asignamos el valor 0 al
			// parámetro, si no, el id de la categoría
			paramSource.addValue("id_categoria",
					socio.getCategoriaSocio() != null ? socio.getCategoriaSocio().getId() : 0);
			paramSource.addValue("estado", socio.getEstado());
		}
		return paramSource;
	}

	// Mapea las filas devueltas a objetos de clase Socio
	private static final class SocioMapper implements RowMapper<Socio> {
		public Socio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Socio socio = new Socio();
			socio.setCategoriaSocio(new CategoriaSocio());
			socio.setId(rs.getInt("id_socio"));
			socio.setDni(rs.getString("dni"));
			socio.setNombre(rs.getString("nombre"));
			socio.setApellido(rs.getString("apellido"));
			socio.setEmail(rs.getString("mail"));
			socio.setDireccion(rs.getString("direccion"));
			socio.setTelefono(rs.getString("telefono"));
			socio.setEstado(rs.getString("estado"));
			socio.getCategoriaSocio().setId(rs.getInt("id_categoria_socio"));

			return socio;
		}
	}

	@Override
	public List<Socio> getAllSocios() {
		List<Socio> lista = namedParameterJdbcTemplate.query(SQL_BUSCAR_TODOS, getSqlParameterByModel(null),
				new SocioMapper());
		return lista;
		
	}

	
	@Override
	public void actualizar(Socio soc) {
		namedParameterJdbcTemplate.update(SQL_ACTUALIZAR, getSqlParameterByModel(soc));

	}

	@Override
	public void agregar(Socio soc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Socio getSocioPorId(int id) {
		Socio socio = namedParameterJdbcTemplate.queryForObject(SQL_BUSCAR_POR_ID,
				getSqlParameterByModel(new Socio(id)), new SocioMapper());
		return socio;
	}

}
