package com.ucr.PuntoDeVenta.Domain;

public class CategoriaEjercicio {

	private int codCategoria;
	private String nombreCategoria;
	
	public CategoriaEjercicio() {
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "CategoriaEjercicio [codCategoria=" + codCategoria + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	
	
	
	
	
}
