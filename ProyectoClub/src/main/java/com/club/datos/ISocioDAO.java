package com.club.datos;

import com.club.entidades.Socio;

public interface ISocioDAO {

	Socio login(String email, String pass);

}
