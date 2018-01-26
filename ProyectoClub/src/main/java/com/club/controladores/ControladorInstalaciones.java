package com.club.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.servicios.IInstalacionServicio;

@Controller
@RequestMapping("/instalaciones" )
@SessionAttributes("usuarioLogueado")
public class ControladorInstalaciones {
	
	@Autowired
	private IInstalacionServicio servicio;
	
	@RequestMapping(method= RequestMethod.GET)
	public String lista(ModelMap model) {
		model.put("listaInstalaciones",servicio.getAllInstalaciones());
		model.put("titulo","Lista de Instalaciones");
		return "instalaciones/lista";
	}
	

}
