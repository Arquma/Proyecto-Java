package com.ucr.GimnasioXyzLibraryB05027;



import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ucr.PuntoDeVenta.DataAccess.ProductoDao;

public class ClienteTest {
  @Test
  public void buscar() {
	
	  
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
	 // ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	  ProductoDao clienteDao = (ProductoDao) context.getBean("productoDao");	  
	  
	  int existencia= clienteDao.getExistencias(4);
	  Assert.assertEquals(5, existencia);
	  }
  }
  
  
}
