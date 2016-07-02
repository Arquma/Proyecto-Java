package com.ucr.GimnasioXyzLibraryB05027;



import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ucr.PuntoDeVenta.DataAccess.ProductoDao;
import com.ucr.PuntoDeVenta.Domain.IngredienteEnProducto;
import com.ucr.PuntoDeVenta.Domain.Producto;

public class ProductoTest {
  @Test
  public void buscarProducto() {
	
	  
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
	 // ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	  ProductoDao clienteDao = (ProductoDao) context.getBean("productoDao");	  
	  
	  Producto produc = clienteDao.buscarProducto(4);
	  Assert.assertEquals(4, produc.getId());
	  }
  }
  
  
  @Test
  public void buscarGetExistencias() {
	
	  
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
	 // ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	  ProductoDao productoDao = (ProductoDao) context.getBean("productoDao");	  
	  
	  int produc = productoDao.getExistencias(4);
	  Assert.assertEquals(2, produc);
	  }
  }
  

  @Test
  public void getProducto() {
	
	  
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
	 // ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	  ProductoDao productoDao = (ProductoDao) context.getBean("productoDao");	  
	  
	  List<IngredienteEnProducto> listado = productoDao.getIngredientes(4);
	  Assert.assertEquals(3, listado.size());
	  }
  }
  
  
  @Test
  public void buscarGetProductos() {
	
	  
	  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")){
	 // ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	  ProductoDao productoDao = (ProductoDao) context.getBean("productoDao");	  
	  
	  List<Producto> productos = productoDao.getProductos();
	  Assert.assertEquals(3, productos.size());
	  }
  }
  
  
}
