package com.ucr.PuntoDeVenta.Domain;

public class IngredienteEnProducto {

	private int idIngredienteProducto;
	private int cantidadRequerida;
	private Ingrediente ingrediente;
	
	public IngredienteEnProducto() {
		ingrediente = new Ingrediente();
	}

	public int getIdIngredienteProducto() {
		return idIngredienteProducto;
	}

	public void setIdIngredienteProducto(int idIngredienteProducto) {
		this.idIngredienteProducto = idIngredienteProducto;
	}

	public int getCantidadRequerida() {
		return cantidadRequerida;
	}

	public void setCantidadRequerida(int cantidadRequerida) {
		this.cantidadRequerida = cantidadRequerida;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	

}
