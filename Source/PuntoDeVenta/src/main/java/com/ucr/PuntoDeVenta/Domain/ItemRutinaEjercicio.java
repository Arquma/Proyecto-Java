package com.ucr.PuntoDeVenta.Domain;

public class ItemRutinaEjercicio {

	private int seriesEjercicio;
	private int repeticionesEjercicio;
	private Ejercicio ejercicio;
	
	public ItemRutinaEjercicio() {
		ejercicio= new Ejercicio();
	}

	public int getSeriesEjercicio() {
		return seriesEjercicio;
	}

	public void setSeriesEjercicio(int seriesEjercicio) {
		this.seriesEjercicio = seriesEjercicio;
	}

	public int getRepeticionesEjercicio() {
		return repeticionesEjercicio;
	}

	public void setRepeticionesEjercicio(int repeticionesEjercicio) {
		this.repeticionesEjercicio = repeticionesEjercicio;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public String toString() {
		return "ItemRutinaEjercicio [seriesEjercicio=" + seriesEjercicio + ", repeticionesEjercicio="
				+ repeticionesEjercicio + ", ejercicio=" + ejercicio + "]";
	}
	
	

}
