package com.club.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.club.entidades.Socio;
import com.club.servicios.IServicioInstalacion;
import com.club.servicios.ISocioServicio;

@Controller
@RequestMapping("/reservas")
@SessionAttributes("usuarioLogueado")
public class ControladorReserva {

	@Autowired
	ISocioServicio socioServicio;

	@Autowired
	IServicioInstalacion instalacionServicio;
	
	//@Autowired
	//IReservaServicio reservaServicio;

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model) {

		// Recupera el socio logueado de la sesión
		Socio socio = (Socio) request.getSession().getAttribute("usuarioLogueado");

		// Si el socio existe, se verifica que esté habilitado. Si no existe, redirige a
		// login, ya que sólo los usuarios identificados pueden realizar reservas
		if (null != socio) {

			if (estaHabilitado(socio)) {
				model.put("listaInstalaciones", instalacionServicio.getAllInstalaciones());
			}

			else {
				model.put("mensajeError", "Usted se encuentra inhabilitado para realizar reservas.");
			}

			model.put("titulo", "Nueva reserva");
			return "reservas/reservas";

		} else {
			return "login";

		}

	}

	private boolean estaHabilitado(Socio socio) {
		boolean habilitado = socioServicio.estaHabilitado(socio.getId());
		return habilitado;

	}
}
