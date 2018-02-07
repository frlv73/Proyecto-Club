package com.club.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.club.entidades.Socio;
import com.club.servicios.ILoginServicio;

@Controller
@RequestMapping("/")
@SessionAttributes("usuarioLogueado") // Atributo de sesión del usuario
public class ControladorLogin {

	@Autowired
	ILoginServicio servicio;

	@RequestMapping(value="/ingresar", method = RequestMethod.POST)
	public String doLogin(@RequestParam("txtEmail") String email, @RequestParam("txtPass") String pass,
			ModelMap model) {

		Socio socio = new Socio();
		socio = servicio.validarUsuario(email, pass);
		if(null != socio) {
		model.put("usuarioLogueado", socio);
		
		} else {
			//TO DO: Mensaje de error en Login
			
		}
		return "redirect:/";
		
	}
	
	
	//TODO NO FUNCIONA
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {
		request.getSession().invalidate();
		request.getSession(true);
		return "index";
	}

}
