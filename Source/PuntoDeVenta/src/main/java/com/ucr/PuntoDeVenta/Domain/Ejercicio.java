package com.ucr.PuntoDeVenta.Domain;

public class Ejercicio {

	private int codEjercicio;
	private String nombreEjercicio;
	private CategoriaEjercicio categoria;
	
	public Ejercicio() {
		categoria= new CategoriaEjercicio();
	}

	public int getCodEjercicio() {
		return codEjercicio;
	}

	public void setCodEjercicio(int codEjercicio) {
		this.codEjercicio = codEjercicio;
	}

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	public CategoriaEjercicio getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEjercicio categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
