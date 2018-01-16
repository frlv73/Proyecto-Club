package com.club.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.servicios.ICategoriaServicio;

@Controller
@RequestMapping("/categorias" )
@SessionAttributes("usuarioLogueado")
public class ControladorCategoria {
	
	@Autowired
	private ICategoriaServicio servicio;
	
	@RequestMapping(method= RequestMethod.GET)
	public String lista(ModelMap model) {
		model.put("listaCategorias", servicio.getAllCategorias());
		model.put("titulo", "Categorias de Socios");
		return "categorias/lista";
		
	}

}
