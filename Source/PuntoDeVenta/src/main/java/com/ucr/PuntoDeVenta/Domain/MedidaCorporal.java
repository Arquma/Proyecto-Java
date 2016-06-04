package com.ucr.PuntoDeVenta.Domain;

public class MedidaCorporal {

	private int codMedida;
	private String unidadMedida;
	private String nombreMedida;
	
	public MedidaCorporal() {
		// TODO Auto-generated constructor stub
	}

	public int getCodMedida() {
		return codMedida;
	}

	public void setCodMedida(int codMedida) {
		this.codMedida = codMedida;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getNombreMedida() {
		return nombreMedida;
	}

	public void setNombreMedida(String nombreMedida) {
		this.nombreMedida = nombreMedida;
	}

	@Override
	public String toString() {
		return "MedidaCorporal [codMedida=" + codMedida + ", unidadMedida=" + unidadMedida + ", nombreMedida="
				+ nombreMedida + "]";
	}
	
	

}
