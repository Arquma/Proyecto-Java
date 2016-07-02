package com.ucr.PuntoDeVenta.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;
import com.ucr.PuntoDeVenta.Business.ProductoBusiness;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@Autowired
	private ProductoBusiness productoBusiness; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(  
		HttpServletRequest request,
		HttpServletResponse response,
		@RequestParam(value = "language",required = false) String language) {
		
		String lan = (language == null || language.isEmpty())?"en":language;
		RequestContextUtils.getLocaleResolver(request).setLocale(request, response, new Locale(lan));
    	
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/productos", method = RequestMethod.GET)
	public @ResponseBody String listaProductos() throws IOException
	{
		
		return new Gson().toJson(productoBusiness.getProductos());
	}
	
	@RequestMapping(value="/ingredientes", method = RequestMethod.POST)
	public @ResponseBody String listaIngredientes(@RequestParam String Id) throws IOException
	{
		
		return new Gson().toJson(productoBusiness.buscarProducto(Integer.parseInt(Id.trim())));
	}

	
	

	
}
