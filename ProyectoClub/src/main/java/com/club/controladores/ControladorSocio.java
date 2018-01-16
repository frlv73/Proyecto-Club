package com.club.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.club.servicios.ISocioServicio;

@Controller
@RequestMapping("/socios" )
public class ControladorSocio {
	
	//@Autowired
	//private ISocioServicio servicio;
	
	@RequestMapping(value="agregar", method= RequestMethod.GET)
	public String agregarSocio(ModelMap model) {
		model.put("titulo", "Nuevo Socio");
		return "socios/nuevoSocio";
	}

}
