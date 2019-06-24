package com.club.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.entidades.CategoriaSocio;
import com.club.entidades.Instalacion;
import com.club.entidades.Socio;
import com.club.servicios.IServicioCategoria;
import com.club.servicios.ISocioServicio;

@Controller
@RequestMapping("/socios")
@SessionAttributes("usuarioLogueado")
public class ControladorSocio {

	 @Autowired
	private ISocioServicio servicio;
	 @Autowired
	private IServicioCategoria servCat;
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

		socio = new Socio();
		model.put("socio", socio);
		model.put("titulo", "Nuevo Socio");
		model.put("listaCategorias", servCat.getAllCategorias());
		model.put("modo", "add");
		return "socios/formSocio";
	}

	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int id) {

		servicio.eliminar(id);
		return "redirect:/socios";
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") int idSocio, ModelMap model) {
		socio = servicio.getSocioPorId(idSocio);
		model.put("socio", socio);
		model.put("titulo", "Modificar Socio");
		model.put("modo", "edit");
		model.put("listaCategorias", servCat.getAllCategorias());
		model.put("modo", "edit");
		return "socios/formSocio";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nom,@RequestParam("apellido") String ape,
			@RequestParam("dni") String d, @RequestParam("localidad") String loc,@RequestParam("direccion") String dir,
			@RequestParam("telefono") String tel, @RequestParam("id_categoria_socio") Integer cat, @RequestParam("email") String m,
			@RequestParam("password") String pass, ModelMap model) {
		
		// Si estamos agregando, no enviamos el id porque se autogenera en la BD. Por lo
		// tanto, lo inicializamos con 0, un valor que ninguna categoría de la BD
		// tendrá.
		if (null == id) {
			id = 0;
		}
		
		socio = new Socio(id,d,nom, ape,loc,dir,tel,cat,m,pass);
		
		if (0 != socio.getId()) {
			servicio.actualizar(socio);
		} else {
			servicio.agregar(socio);
		}

		return "redirect:/socios";
	}

}
