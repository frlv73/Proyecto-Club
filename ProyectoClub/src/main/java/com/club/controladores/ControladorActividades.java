package com.club.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.entidades.Actividad;
import com.club.servicios.IActividadServicio;


@Controller
@RequestMapping("/actividades")
@SessionAttributes("usuarioLogueado")
public class ControladorActividades {
	
	@Autowired
	private IActividadServicio servicio;
	
	private Actividad actividad;
	
	
	//Lista de categorías
		@RequestMapping(method= RequestMethod.GET)
		public String lista(ModelMap model) {
			model.put("listaActividades", servicio.getAllActividades());
			model.put("titulo", "Actividades del Club");
			return "actividades/lista";
			
		}
		
		//Nueva categoría
		@RequestMapping(value = "/agregar", method = RequestMethod.GET)
		public String agregar(ModelMap model) {
			actividad= new Actividad();
			model.addAttribute("actividad", actividad);
			model.put("titulo", "Nueva Actividad");
			model.put("modo", "add");
			return "actividades/form";
		}
		
		//Editar Categoria
		@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
		public String editar(@PathVariable("id") int idActividad, ModelMap model) {
			actividad = servicio.getActividadPorId(idActividad);
			model.addAttribute("categoria", actividad);
			model.addAttribute("titulo", "Modificar Actividad");
			model.put("modo", "edit");
			return "actividades/form";
		}
		
		// Procesa el form de agregar y editar. Revisar que funcione el ModelAttribute
		@RequestMapping(value = "/guardar", method = RequestMethod.POST)
		public String guardar(@RequestParam(value = "id", required = false) Integer id,
				@RequestParam("descripcion") String desc, @RequestParam("estado") String estado, @RequestParam("costo") double costo, ModelMap model) {
			
			// Si estamos agregando, no enviamos el id porque se autogenera en la BD. Por lo
			// tanto, lo inicializamos con 0, un valor que ninguna categoría de la BD
			// tendrá.
			if (null == id) {
				id = 0;
			}
			
			actividad = new Actividad(id, desc, estado, costo);
			
			if (0 != actividad.getId_actividad()) {
				servicio.actualizar(actividad);
			} else {
				servicio.agregar(actividad);
			}

			return "redirect:/actividades";
		}

		//Eliminar la categoría
		@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
		public String eliminar(@PathVariable("id") int id) {

			servicio.eliminar(id);
			return "actividades/lista";
		}
	
	
	

}
