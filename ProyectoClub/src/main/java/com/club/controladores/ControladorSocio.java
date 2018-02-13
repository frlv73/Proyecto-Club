package com.club.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.club.entidades.Instalacion;
import com.club.entidades.Socio;
import com.club.servicios.ISocioServicio;

@Controller
@RequestMapping("/socios")
public class ControladorSocio {

	 @Autowired
	private ISocioServicio servicio;
	private Socio socio;
	 
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

	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String agregar(ModelMap model) {

		// TODO es necesario crear una nueva instalación o es mejor crearla cuando
		// proceso el formulario?
		socio = new Socio();
		model.put("socio", socio);
		model.put("titulo", "Nuevo Socio");
		model.put("modo", "add");
		return "socios/nuevoSocio";
	}

	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int id) {

		servicio.eliminar(id);
		return "socios/listaSocios";
	}

}
