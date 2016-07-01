package com.ucr.PuntoDeVenta.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ucr.PuntoDeVenta.Domain.Producto;

public class ProductoDao {

	private JdbcTemplate jdbcTemplate;

	public ProductoDao() {
		// TODO Auto-generated constructor stub
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Producto> getProductos() {
		List<Producto> productos = this.jdbcTemplate.query(
				"select id_producto,nombre,precio,existencias,preparacion from producto", new RowMapper<Producto>() {
					@Override
					public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Producto producto = new Producto();
						producto.setId(Integer.parseInt(rs.getString("id_producto")));
						producto.setNombre(rs.getString("nombre"));
						producto.setPrecio(Float.parseFloat(rs.getString("precio")));
						producto.setExistencias(Integer.parseInt(rs.getString("existencias")));
						producto.setPreparacion((Integer.parseInt(rs.getString("preparacion"))) == 0 ? false : true);

						return producto;
					}
				});
		return productos;
	}

}
