package com.club.controladores;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.club.entidades.Socio;
import com.club.servicios.IActividadServicio;
import com.club.servicios.ISocioServicio;

@Controller
@RequestMapping("/reportes")
public class ControladorReportes {

	@Autowired
	ISocioServicio socioServicio;
	
	@Autowired
	IActividadServicio actividadServicio;

	@RequestMapping(value="/reservasPorSocio", method = RequestMethod.GET)
	public String sociosConMasReservas(ModelMap model) {

		model.put("socios", socioServicio.getAllSociosConReservas());
		model.put("titulo", "Reporte de reservas por socio");
		return "/reportes/reservasPorSocio";
	}
	
	@RequestMapping(value="/actividadesConInscriptos", method = RequestMethod.GET)
	public String actividadesConInscriptos(ModelMap model) {
		model.put("actividades", actividadServicio.getActividadesConInscriptos());
		model.put("titulo", "Reporte de actividades con inscriptos");
		return "/reportes/actividadesConInscriptos";
	}

	
	
	
}
