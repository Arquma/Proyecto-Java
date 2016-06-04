package com.ucr.PuntoDeVenta.DataAccess;

import org.springframework.jdbc.core.JdbcTemplate;

public class RutinaDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public RutinaDao() {
		
		
	}
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
