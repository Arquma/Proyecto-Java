package com.ucr.PuntoDeVenta.Controllers;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ucr.PuntoDeVenta.Business.ClienteBusiness;
import com.ucr.PuntoDeVenta.Domain.Cliente;

@Controller
public class ClienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ClienteBusiness clienteBusiness; 
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String insertarCliente(Locale locale, Model model) {
		
		return "insertarCliente";
	}
	
	@RequestMapping(value="/cliente", method = RequestMethod.POST)
	public @ResponseBody void insert(@RequestParam String Nombre,
										@RequestParam String Apellidos,
										@RequestParam String Telefono,
										@RequestParam String Direccion,
										@RequestParam String FechaNacimiento,
										@RequestParam String ContactoEmergencia,
										@RequestParam String TelefonoEmergencia) 
	{
		
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha= new Date();
		try {
			fecha = myFormat.parse(FechaNacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Cliente cliente = new Cliente();
		cliente.setNombreCliente(Nombre);
		cliente.setApellidoCliente(Apellidos);
		cliente.setTelefono(Telefono);
		cliente.setFechaNacimiento(fecha);
		cliente.setDireccion(Direccion);
		cliente.setNombreContactoCasoEmergencia(ContactoEmergencia);
		cliente.setTelContactoCasoEmergencia(TelefonoEmergencia);

		clienteBusiness.insertar(cliente);
		
		
	}
	
	
	@RequestMapping(value="/clientes", method = RequestMethod.GET)
	public @ResponseBody String listaClientes() throws IOException
	{
		
		return new Gson().toJson(clienteBusiness.listaClientes());
	}

	public ClienteBusiness getClienteBusiness() {
		return clienteBusiness;
	}


	public void setClienteBusiness(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}
	
}
