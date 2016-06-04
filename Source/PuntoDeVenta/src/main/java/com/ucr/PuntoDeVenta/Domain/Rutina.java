package com.ucr.PuntoDeVenta.Domain;

import java.util.Date;
import java.util.LinkedList;

public class Rutina {

		private int codRutina;
		private Date fechaCreacion;
		private Date fechaRenovacion;
		private String objetivoCliente;
		private String enfermedadesCliente;
		private boolean vigente;
		private Cliente cliente;
		private LinkedList<ItemRutinaEjercicio> itemsRutina; 
		private LinkedList<ItemRutinaMedida>  itemMedida;
				
		public Rutina() {
			cliente = new Cliente();
			itemsRutina = new LinkedList<ItemRutinaEjercicio>();
			itemMedida = new LinkedList<ItemRutinaMedida>();
		}
		
		
		public int getCodRutina() {
			return codRutina;
		}
		public void setCodRutina(int codRutina) {
			this.codRutina = codRutina;
		}
		public Date getFechaCreacion() {
			return fechaCreacion;
		}
		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
		public Date getFechaRenovacion() {
			return fechaRenovacion;
		}
		public void setFechaRenovacion(Date fechaRenovacion) {
			this.fechaRenovacion = fechaRenovacion;
		}
		public String getObjetivoCliente() {
			return objetivoCliente;
		}
		public void setObjetivoCliente(String objetivoCliente) {
			this.objetivoCliente = objetivoCliente;
		}
		public String getEnfermedadesCliente() {
			return enfermedadesCliente;
		}
		public void setEnfermedadesCliente(String enfermedadesCliente) {
			this.enfermedadesCliente = enfermedadesCliente;
		}
		public boolean isVigente() {
			return vigente;
		}
		public void setVigente(boolean vigente) {
			this.vigente = vigente;
		}
		
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public LinkedList<ItemRutinaEjercicio> getItemsRutina() {
			return itemsRutina;
		}
		public void setItemsRutina(LinkedList<ItemRutinaEjercicio> itemsRutina) {
			this.itemsRutina = itemsRutina;
		}
		


		public LinkedList<ItemRutinaMedida> getItemMedida() {
			return itemMedida;
		}


		public void setItemMedida(LinkedList<ItemRutinaMedida> itemMedida) {
			this.itemMedida = itemMedida;
		}


		@Override
		public String toString() {
			return "Rutina [codRutina=" + codRutina + ", fechaCreacion=" + fechaCreacion + ", fechaRenovacion="
					+ fechaRenovacion + ", objetivoCliente=" + objetivoCliente + ", lesionesCliente=" 
					+ enfermedadesCliente + ", vigente=" + vigente + "]";
		}
		
		
}
