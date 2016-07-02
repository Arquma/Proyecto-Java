package com.ucr.PuntoDeVenta.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ucr.PuntoDeVenta.Domain.IngredienteEnProducto;
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
						
							int requerida = Integer.parseInt(rs.getString("cantidad_requerida"));
							int existen =Integer.parseInt(rs.getString("existencias"));
							
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
		
		
		public Producto buscarProducto(int id) {
			Producto producto = this.jdbcTemplate.queryForObject(
					"select id_producto,nombre,precio,existencias,preparacion from producto where id_producto=?",
					new Object[]{ id },
					new RowMapper<Producto>() {
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
								producto.setIngredientes(getIngredientes(producto.getId()));
							}
							return producto;
						}
					});
			return producto;
		}
	
		public List<IngredienteEnProducto> getIngredientes(int id) {
			List<IngredienteEnProducto> ingredientes = this.jdbcTemplate.query(
					"select ip.id_ingrediente ingredienteProducto, ip.cantidad_requerida, i.id_ingrediente,i.existencias, i.nombre from ingrediente_producto ip, ingrediente i where i.id_ingrediente = ip.id_ingrediente and ip.id_producto = " + id, new RowMapper<IngredienteEnProducto>() {
						@Override
						public IngredienteEnProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
							IngredienteEnProducto ingrediente = new IngredienteEnProducto();
							ingrediente.setIdIngredienteProducto(Integer.parseInt(rs.getString("ingredienteProducto")));
							ingrediente.setCantidadRequerida(Integer.parseInt(rs.getString("cantidad_requerida")));
							ingrediente.getIngrediente().setId(Integer.parseInt(rs.getString("id_ingrediente")));
							ingrediente.getIngrediente().setExistencias(Integer.parseInt(rs.getString("existencias")));
							ingrediente.getIngrediente().setNombre(rs.getString("nombre"));
							
							return ingrediente;
						}
					});
			return ingredientes;
		}

}
