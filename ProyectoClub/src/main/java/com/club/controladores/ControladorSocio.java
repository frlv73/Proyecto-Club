package com.club.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.club.entidades.Socio;
import com.club.servicios.ISocioServicio;

@Controller
@RequestMapping("/socios")
public class ControladorSocio {

	 @Autowired
	private ISocioServicio servicio;
	 
	 @RequestMapping(method = RequestMethod.GET)
		public String lista(ModelMap model) {
			model.put("listaSocios", servicio.getAllSocios());
			model.put("titulo", "Lista de Socios");
			return "socios/listaSocios";
		}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrar(@ModelAttribute("formSocio") Socio socio, ModelMap model) {
		servicio.registrar(socio);
		return "/login";
	}

}
