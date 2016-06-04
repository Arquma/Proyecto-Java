package com.ucr.PuntoDeVenta.Domain;

import java.util.Date;

public class DatosGimnasio {

	private int numIdentificacion;
	private String nombreCliente;
	private String apellidoCliente;
	private Date fechaNacimiento;
	private String telefono;
	private String direccion;
	private String nombreContactoEmergencia;
	private String telefonoContactoEmergencia;
	
	public DatosGimnasio() {
		// TODO Auto-generated constructor stub
	}

	public int getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(int numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreContactoEmergencia() {
		return nombreContactoEmergencia;
	}

	public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
		this.nombreContactoEmergencia = nombreContactoEmergencia;
	}

	public String getTelefonoContactoEmergencia() {
		return telefonoContactoEmergencia;
	}

	public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
		this.telefonoContactoEmergencia = telefonoContactoEmergencia;
	}

	@Override
	public String toString() {
		return "DatosGimnasio [numIdentificacion=" + numIdentificacion + ", nombreCliente=" + nombreCliente
				+ ", apellidoCliente=" + apellidoCliente + ", fechaNacimiento=" + fechaNacimiento + ", telefono="
				+ telefono + ", direccion=" + direccion + ", nombreContactoEmergencia=" + nombreContactoEmergencia
				+ ", telefonoContactoEmergencia=" + telefonoContactoEmergencia + "]";
	}
	
	

}
