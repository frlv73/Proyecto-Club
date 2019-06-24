package com.club.controladores.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.club.entidades.Actividad;
import com.club.entidades.Instalacion;
import com.club.servicios.IServicioActividad;

@RestController
@RequestMapping("/api/actividades")
public class ControladorRestActividad {
	
	@Autowired
	IServicioActividad servicioActividad;
	
	Actividad actividad;

	@GetMapping()
	@ResponseBody
	public List<Actividad> getAll(){
		return servicioActividad.getAllActividades();
	}
	
	public ResponseEntity<Actividad> getAll(@PathVariable int id){
		try {
			Actividad acividad =servicioActividad.getActividadPorId(id);
		if(acividad== null)
			return new ResponseEntity<Actividad>(HttpStatus.NOT_FOUND);
			else return new ResponseEntity<Actividad>(acividad, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Actividad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Actividad> nuevaActividad(@RequestBody Actividad actividad) {
		try {
			servicioActividad.agregar(actividad);
		return new ResponseEntity<Actividad>(actividad, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Actividad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
