package com.ucr.PuntoDeVenta.Domain;

public class ItemRutinaMedida {

	private float valorMedidda;
	private MedidaCorporal medidaCorporal;
	
	
	public ItemRutinaMedida() {
		medidaCorporal = new MedidaCorporal();
	}


	public float getValorMedidda() {
		return valorMedidda;
	}


	public void setValorMedidda(float valorMedidda) {
		this.valorMedidda = valorMedidda;
	}


	public MedidaCorporal getMedidaCorporal() {
		return medidaCorporal;
	}


	public void setMedidaCorporal(MedidaCorporal medidaCorporal) {
		this.medidaCorporal = medidaCorporal;
	}


	@Override
	public String toString() {
		return "ItemRutinaMedida [valorMedidda=" + valorMedidda + ", medidaCorporal=" + medidaCorporal + "]";
	}
	
	

}
