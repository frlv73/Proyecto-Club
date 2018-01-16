package com.club.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.datos.ISocioDAO;
import com.club.entidades.Socio;

@Service
public class LoginServicio implements ILoginServicio{

	@Autowired
	private ISocioDAO dao;
	
	@Override
	public Socio validarUsuario(String email, String pass) {
		
		return dao.login(email, pass);
		
	}

}
