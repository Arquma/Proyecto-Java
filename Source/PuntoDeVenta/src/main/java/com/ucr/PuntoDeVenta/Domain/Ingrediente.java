package com.ucr.PuntoDeVenta.Domain;

public class Ingrediente {

	private int id;
	private int existencias;
	private String nombre;
	
	
	public Ingrediente() {
		// Do nothing 
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getExistencias() {
		return existencias;
	}


	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
