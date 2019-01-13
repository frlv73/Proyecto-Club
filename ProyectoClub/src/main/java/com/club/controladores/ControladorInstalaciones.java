package com.club.controladores;

import static org.mockito.Matchers.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.entidades.Instalacion;
import com.club.servicios.IInstalacionServicio;

@Controller
@RequestMapping("/instalaciones")
@SessionAttributes("usuarioLogueado")
public class ControladorInstalaciones {

	@Autowired
	private IInstalacionServicio servicio;

	private Instalacion instalacion;

	// Página lista de instalaciones
	@RequestMapping(method = RequestMethod.GET)
	public String lista(ModelMap model) {
		model.put("listaInstalaciones", servicio.getAllInstalaciones());
		model.put("titulo", "Lista de Instalaciones");
		return "instalaciones/lista";
	}

	// Página crear instalación
	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String agregar(ModelMap model) {

		// TODO es necesario crear una nueva instalación o es mejor crearla cuando
		// proceso el formulario?
		instalacion = new Instalacion();
		model.put("instalacion", instalacion);
		model.put("titulo", "Nueva Instalación");
		model.put("modo", "add");
		return "instalaciones/form";
	}

	// Página para editar instalación. Tanto agregar como editar redirigen a la
	// misma página, pero editar llenará los campos con la marca recuperada de la BD
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") int idInstalacion, ModelMap model) {
		instalacion = servicio.getInstalacionPorId(idInstalacion);
		model.put("instalacion", instalacion);
		model.put("titulo", "Modificar Instalación");
		model.put("modo", "edit");
		return "instalaciones/form";
	}

	// Procesa el form de agregar y editar.
	/*
	 * No me funciona con el ModelAttribute. Revisar.
	 * 
	 * @RequestMapping(value = "/guardar", method = RequestMethod.POST) public
	 * String guardar(@ModelAttribute("instalacion") Instalacion ins, ModelMap
	 * model)
	 */
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("descripcion") String desc, @RequestParam("estado") String estado, ModelMap model) {

		// Si estamos agregando, no enviamos el id porque se autogenera en la BD. Por lo
		// tanto, lo inicializamos con 0, un valor que ninguna instalacion de la BD
		// tendrá.
		if (null == id) {
			id = 0;
		}

		instalacion = new Instalacion(id, desc, estado);

		if (0 != instalacion.getId()) {
			servicio.actualizar(instalacion);
		} else {
			servicio.agregar(instalacion);
		}

		return "redirect:/instalaciones";
	}

	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int id) {

		servicio.eliminar(id);
		return "redirect:/instalaciones";
	}

}
