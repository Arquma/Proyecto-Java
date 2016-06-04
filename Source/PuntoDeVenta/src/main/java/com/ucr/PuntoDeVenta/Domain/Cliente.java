package com.ucr.PuntoDeVenta.Domain;

import java.util.Date;


public class Cliente {

	private int numIdentificacion;
	private String nombreCliente;
	private String apellidoCliente;
	private Date fechaNacimiento;
	private String telefono;
	private String direccion;
	private String nombreContactoCasoEmergencia;
	private String telContactoCasoEmergencia;
	
	public Cliente() {
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

	public String getNombreContactoCasoEmergencia() {
		return nombreContactoCasoEmergencia;
	}

	public void setNombreContactoCasoEmergencia(String nombreContactoCasoEmergencia) {
		this.nombreContactoCasoEmergencia = nombreContactoCasoEmergencia;
	}

	public String getTelContactoCasoEmergencia() {
		return telContactoCasoEmergencia;
	}

	public void setTelContactoCasoEmergencia(String telContactoCasoEmergencia) {
		this.telContactoCasoEmergencia = telContactoCasoEmergencia;
	}
	
	
	
	
}
