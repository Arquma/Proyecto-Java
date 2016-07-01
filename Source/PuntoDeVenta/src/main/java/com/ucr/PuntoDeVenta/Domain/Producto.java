package com.ucr.PuntoDeVenta.Domain;


import java.util.ArrayList;
import java.util.List;


public class Producto {

	private int id;
	private String nombre;
	private float precio;
	private int existencias;
	private boolean preparacion;
	private List<Ingrediente> ingredientes;
	
	public Producto() {

		ingredientes =  new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public boolean isPreparacion() {
		return preparacion;
	}

	public void setPreparacion(boolean preparacion) {
		this.preparacion = preparacion;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	
	
	

}
