package com.ucr.PuntoDeVenta.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ucr.PuntoDeVenta.Domain.CategoriaEjercicio;
import com.ucr.PuntoDeVenta.Domain.Cliente;
import com.ucr.PuntoDeVenta.Domain.Ejercicio;

public class EjercicioDao {

	private JdbcTemplate jdbcTemplate;
	
	public EjercicioDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Ejercicio> getEjercicios(){
		List<Ejercicio> ejercicios = this.jdbcTemplate.query(
				"SELECT cod_ejercicio,nombre_ejercio,cod_categoria,cod_equipo from ejercicio",
		        new RowMapper<Ejercicio>() {
		            public Ejercicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	Ejercicio ejercicio = new Ejercicio();
		            	ejercicio.setNombreEjercicio(rs.getString("nombre_ejercio"));
		            	ejercicio.setCategoria(new CategoriaEjercicio());
		            	ejercicio.setCodEjercicio(rs.getInt("cod_ejercicio"));
						
		                return ejercicio;
		            }
		        });
		return ejercicios;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
