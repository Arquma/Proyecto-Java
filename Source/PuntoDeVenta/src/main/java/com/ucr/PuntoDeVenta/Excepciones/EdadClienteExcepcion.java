package com.ucr.PuntoDeVenta.Excepciones;

public class EdadClienteExcepcion extends RuntimeException{

	/**
	 * 
	 */
	private String error;
	public EdadClienteExcepcion(String error) {
		this.error =	error;
	}

}
