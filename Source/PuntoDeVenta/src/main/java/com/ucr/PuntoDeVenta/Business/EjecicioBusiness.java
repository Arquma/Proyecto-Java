package com.ucr.PuntoDeVenta.Business;

import java.util.List;

import com.ucr.PuntoDeVenta.DataAccess.ClienteDao;
import com.ucr.PuntoDeVenta.DataAccess.EjercicioDao;
import com.ucr.PuntoDeVenta.Domain.Ejercicio;

public class EjecicioBusiness {

	private EjercicioDao ejercicioDao;

	
	public EjecicioBusiness() {

	}
	
	public List<Ejercicio> getEjercicios(){
		return this.ejercicioDao.getEjercicios();
	}

	public EjercicioDao getEjercicioDao() {
		return ejercicioDao;
	}


	public void setEjercicioDao(EjercicioDao ejercicioDao) {
		this.ejercicioDao = ejercicioDao;
	}

	
	
}
