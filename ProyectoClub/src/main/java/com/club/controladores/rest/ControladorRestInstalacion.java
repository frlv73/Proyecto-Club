package com.club.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public List<Instalacion> getAll(){
		return servicioInstalacion.getAllInstalaciones();
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public Instalacion getAll(@PathVariable int id){
		return servicioInstalacion.getInstalacionPorId(id);
	}
	
	@PostMapping()
	public Instalacion nuevaInstalacion(@RequestBody Instalacion instalacion) {
		servicioInstalacion.agregar(instalacion);
		return instalacion;
	}
	
	

}
