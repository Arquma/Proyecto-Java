package com.ucr.PuntoDeVenta.Controllers;

import java.awt.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RutinaController {

	
	public RutinaController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/rutina", method = RequestMethod.GET)
	public String insertarRutina(Locale locale, Model model) {
		
		
		return "insertarRutina";
	}

}
