package com.ucr.PuntoDeVenta.Business;


import java.util.List;

import com.ucr.PuntoDeVenta.DataAccess.ClienteDao;
import com.ucr.PuntoDeVenta.Domain.Cliente;

public class ClienteBusiness {
	
	
	private ClienteDao clienteDao;
	
	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public List<Cliente> listaClientes(){
		return clienteDao.getClientes();
	}

	public ClienteBusiness() {
	}
	
	public boolean insertar(Cliente cliente){
		
		return clienteDao.insertar(cliente);
	}
	

}
