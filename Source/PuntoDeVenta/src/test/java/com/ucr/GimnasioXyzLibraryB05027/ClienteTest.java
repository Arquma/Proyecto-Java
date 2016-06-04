package com.ucr.GimnasioXyzLibraryB05027;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ucr.PuntoDeVenta.DataAccess.ClienteDao;
import com.ucr.PuntoDeVenta.Domain.Cliente;

public class ClienteTest {
  @Test
  public void buscar() {
	
	  
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
	 // ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	  ClienteDao clienteDao = (ClienteDao) context.getBean("clienteDao");	  
	  
	  Cliente cliente = new Cliente();
	  cliente= clienteDao.buscar(2);
	  Assert.assertEquals("Aaron", cliente.getNombreCliente());
	  }
  }
  
  @Test
  public void insertar() {
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
		  ClienteDao clienteDao = (ClienteDao) context.getBean("clienteDao");
		  Cliente cliente = new Cliente();
	      Assert.assertEquals(true,clienteDao.insertar(cliente));
	  }
  }
  
}
