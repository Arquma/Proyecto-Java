package com.ucr.PuntoDeVenta.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ucr.PuntoDeVenta.Domain.Ingrediente;
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
						if(producto.isPreparacion()){
							producto.setExistencias(getExistencias(producto.getId()));
						}
						return producto;
					}
				});
		return productos;
	}
	
	
	
		public int getExistencias(int id) {
			List<Producto> productos = this.jdbcTemplate.query(
					"select ip.cantidad_requerida,i.existencias from ingrediente_producto ip, ingrediente i where i.id_ingrediente = ip.id_ingrediente and ip.id_producto = "+id,
					new RowMapper<Producto>() {
						@Override
						public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
							Producto producto = new Producto();
							int cantidad = 0;
							int requerida = (Integer.parseInt(rs.getString("cantidad_requerida")));
							int existen =(Integer.parseInt(rs.getString("existencias")));
							
							producto.setExistencias(existen/requerida);
							return producto;
						}
					});
			
			int numero_menor = 10000;
			for (Producto producto : productos) {
				if(producto.getExistencias()<numero_menor){
					numero_menor=producto.getExistencias();
				}
			}
			
			
			return numero_menor;
		}
	
	

}
