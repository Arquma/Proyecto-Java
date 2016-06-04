package com.ucr.PuntoDeVenta.DataAccess;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ucr.PuntoDeVenta.Domain.Cliente;



public class ClienteDao {
	
	
	private JdbcTemplate jdbcTemplate;

	public ClienteDao() {
		
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public Cliente buscar(int id){
		
		
		Cliente cliente = this.jdbcTemplate.queryForObject(
				"select id_cliente,nombre_cliente,apellidos_cliente,fecha_nacimiento,telefono,direccion,nombre_contacto_emergencia,tel_contacto_emergencia from cliente where id_cliente = ?",
				new Object[]{ id },
				new RowMapper<Cliente>() {
					public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
						Cliente cliente = new Cliente();
						cliente.setNombreCliente(rs.getString("nombre_cliente"));
						cliente.setApellidoCliente(rs.getString("apellidos_cliente"));
						cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
						cliente.setTelefono(rs.getString("telefono"));
						cliente.setDireccion(rs.getString("direccion"));
						cliente.setNombreContactoCasoEmergencia(rs.getString("nombre_contacto_emergencia"));
						cliente.setTelContactoCasoEmergencia(rs.getString("tel_contacto_emergencia"));
						cliente.setNumIdentificacion (rs.getInt("id_cliente"));
						return cliente;
					}
				});
		
		
		return cliente;
		
	}
	
public boolean insertar(Cliente cliente){
	jdbcTemplate.update("INSERT INTO cliente(nombre_cliente,apellidos_cliente,fecha_nacimiento,telefono,direccion,nombre_contacto_emergencia,tel_contacto_emergencia) "
						+ "			VALUES(?,?,?,?,?,?,?)"
						, cliente.getNombreCliente(), cliente.getApellidoCliente(), cliente.getFechaNacimiento(),cliente.getTelefono(),cliente.getDireccion(),cliente.getNombreContactoCasoEmergencia(),cliente.getTelContactoCasoEmergencia());
		
		return true;
		
	}

public List<Cliente> getClientes(){
	List<Cliente> clientes = this.jdbcTemplate.query(
			"select id_cliente,nombre_cliente,apellidos_cliente,fecha_nacimiento,telefono,direccion,nombre_contacto_emergencia,tel_contacto_emergencia from cliente ",
	        new RowMapper<Cliente>() {
	            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Cliente cliente = new Cliente();
	            	cliente.setNombreCliente(rs.getString("nombre_cliente"));
					cliente.setApellidoCliente(rs.getString("apellidos_cliente"));
					cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
					cliente.setTelefono(rs.getString("telefono"));
					cliente.setDireccion(rs.getString("direccion"));
					cliente.setNombreContactoCasoEmergencia(rs.getString("nombre_contacto_emergencia"));
					cliente.setTelContactoCasoEmergencia(rs.getString("tel_contacto_emergencia"));
					cliente.setNumIdentificacion (rs.getInt("id_cliente"));
	                return cliente;
	            }
	        });
	return clientes;
}
	
	

}
