package com.club.servicios;

import com.club.entidades.Socio;

public interface ILoginServicio {

	Socio validarUsuario(String email, String pass);

}
