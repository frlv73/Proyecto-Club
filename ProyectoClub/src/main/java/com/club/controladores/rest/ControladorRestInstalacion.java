package com.club.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.club.entidades.Instalacion;
import com.club.servicios.IServicioInstalacion;

@RestController
@RequestMapping("/api/instalaciones")
public class ControladorRestInstalacion {

	@Autowired
	IServicioInstalacion servicioInstalacion;

	Instalacion instalacion;

	@GetMapping()
	@ResponseBody
	public List<Instalacion> getAll() {
		return servicioInstalacion.getAllInstalaciones();
	}

	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<Instalacion> getAll(@PathVariable int id){
		try {
		Instalacion ins =servicioInstalacion.getInstalacionPorId(id);
		if(ins== null)
			return new ResponseEntity<Instalacion>(HttpStatus.NOT_FOUND);
			else return new ResponseEntity<Instalacion>(ins, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Instalacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Instalacion> nuevaInstalacion(@RequestBody Instalacion instalacion) {
		try {
		servicioInstalacion.agregar(instalacion);
		return new ResponseEntity<Instalacion>(instalacion, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Instalacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
