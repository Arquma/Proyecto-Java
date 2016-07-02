package com.ucr.PuntoDeVenta.Business;

import java.util.List;

import com.ucr.PuntoDeVenta.DataAccess.ProductoDao;
import com.ucr.PuntoDeVenta.Domain.Producto;

public class ProductoBusiness {

	private ProductoDao productoDao;

	public ProductoBusiness() {
		// TODO Auto-generated constructor stub
	}

	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	public List<Producto> getProductos() {
		return productoDao.getProductos();
	}
	
	public Producto buscarProducto(int id) {
		return productoDao.buscarProducto(id);
	}
	

}
