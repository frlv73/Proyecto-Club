package com.club.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.entidades.CategoriaSocio;
import com.club.servicios.ICategoriaServicio;

@Controller
@RequestMapping("/categorias" )
@SessionAttributes("usuarioLogueado")
public class ControladorCategoria {
	
	@Autowired
	private ICategoriaServicio servicio;
	
	private CategoriaSocio categoria;
	
	//Lista de categorías
	@RequestMapping(method= RequestMethod.GET)
	public String lista(ModelMap model) {
		model.put("listaCategorias", servicio.getAllCategorias());
		model.put("titulo", "Categorias de Socios");
		return "categorias/lista";
		
	}
	
	//Nueva categoría
	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String agregar(ModelMap model) {
		categoria= new CategoriaSocio();
		model.addAttribute("categoria", categoria);
		model.put("titulo", "Nueva Categoría");
		return "categorias/form";
	}
	
	//Editar Categoria
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") int idCategoria, Model model) {
		categoria = servicio.getCategoriaPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		model.addAttribute("titulo", "Modificar Instalación");
		return "categorias/form";
	}
	
	// Procesa el form de agregar y editar. Revisar que funcione el ModelAttribute
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(@ModelAttribute("categoria") CategoriaSocio cat, ModelMap model) {
		if (null != cat && 0 != cat.getId()) {
			servicio.actualizar(cat);
		} else {
			servicio.agregar(cat);
		}

		return "categorias/lista";
	}

	//Eliminar la categoría
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int id) {

		servicio.eliminar(id);
		return "categorias/lista";
	}

}
