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

import com.club.entidades.Categoria;
import com.club.entidades.CategoriaSocio;
import com.club.entidades.Instalacion;
import com.club.servicios.IServicioCategoria;
import com.club.servicios.IServicioInstalacion;

@RestController
@RequestMapping("/api/categorias")
public class ControladorRestCategoria {
	@Autowired
	IServicioCategoria servicioCategoria;


	@GetMapping()
	@ResponseBody
	public List<CategoriaSocio> getAll() {
		return servicioCategoria.getAllCategorias();
	}

	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<CategoriaSocio> getAll(@PathVariable int id){
		try {
			CategoriaSocio categoriaSocio =servicioCategoria.getCategoriaPorId(id);
		if(categoriaSocio== null)
			return new ResponseEntity<CategoriaSocio>(HttpStatus.NOT_FOUND);
			else return new ResponseEntity<CategoriaSocio>(categoriaSocio, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<CategoriaSocio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<CategoriaSocio> nuevaCategoria(@RequestBody CategoriaSocio categoria) {
		
		try {
			servicioCategoria.agregar(categoria);
			return new ResponseEntity<CategoriaSocio>(categoria, HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ResponseEntity<CategoriaSocio>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			

}
}
