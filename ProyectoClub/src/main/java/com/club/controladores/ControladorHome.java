package com.club.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioLogueado")
public class ControladorHome {
	
	@RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		modelMap.put("titulo", "Página de inicio");
	
		return "index";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("titulo", "Login");
		return "login";
	}

}
