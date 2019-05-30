package com.club.controladores.rest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ControladorRestLogin {

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String asdas() {
		return "dasd";
	}
}
