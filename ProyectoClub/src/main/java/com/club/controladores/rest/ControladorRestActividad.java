package com.club.controladores.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.club.entidades.Actividad;
import com.club.servicios.IActividadServicio;

@RestController
@RequestMapping("/api/actividades")
public class ControladorRestActividad {
	
	@Autowired
	IActividadServicio servicioActividad;

	@GetMapping()
	@ResponseBody
	public List<Actividad> lista(){
		return servicioActividad.getAllActividades();
	}
}
