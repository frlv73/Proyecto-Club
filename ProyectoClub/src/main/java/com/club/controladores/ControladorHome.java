package com.club.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioLogueado")
@RequestMapping(value={"/", "/index"})
public class ControladorHome {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		modelMap.put("titulo", "Página de inicio");
	
		return "index";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("titulo", "Login");
		return "login";
	}
	
	@RequestMapping(value="/registro", method= RequestMethod.GET)
	public String agregarSocio(ModelMap model) {
		model.put("titulo", "Nuevo Socio");
		return "socios/formSocio";
	}
	
	@RequestMapping(value="/reportes", method=RequestMethod.GET)
	public String reportes(ModelMap model) {
		model.put("titulo", "Reportes");
		return "reporte";
	}

}
