package com.logistic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.logistic.dao.Tipo_productoDao;
import com.logistic.model.Bodegas;
import com.logistic.model.Tipo_producto;

@Repository
public class Tipo_productoDaoImpl implements Tipo_productoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer nextVal() {
		// TODO Auto-generated method stub
		Integer id = jdbcTemplate.queryForObject("SELECT max(ID_PRODUCTO) + 1 FROM TIPO_PRODUCTO", Integer.class);
		if(id.equals(null))
			id = 1;
		return id;
	}

	@Override
	public Integer save(Tipo_producto data) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO TIPO_PRODUCTO ( ");
		sql.append("     ID_PRODUCTO, ");	
		sql.append("     TIPO, ");
		sql.append("     DESCUENTO, ");
		sql.append("     CANTIDAD_DESCUENTO, ");
		sql.append("     USUARIO, ");				
		sql.append("     FECHA_REGISTRO) ");
		sql.append("  VALUES (?, ?, ?, ?, ?, ?)");
				
		
		return resultado = jdbcTemplate.update(sql.toString(), nextVal(), data.getTipo(), 				
				data.getDescuento(), data.getCantidad_descuento(), data.getUsuario(), data.getFecha_registro());
	}

	@Override
	public Integer update(Tipo_producto data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE TIPO_PRODUCTO");
        sql.append(" SET DESCUENTO             = ?,");
        sql.append("	CANTIDAD_DESCUENTO             = ?,");
        sql.append("     USUARIO           = ?,");
        sql.append("     FECHA_MODIFICA                = ?");               
        sql.append(" WHERE ID_PRODUCTO = ?");
        return jdbcTemplate.update(sql.toString(), data.getDescuento(),         		 
        		data.getCantidad_descuento(), data.getUsuario(),
        		new Date(),
        		data.getId_producto());
	}

	@Override
	public Tipo_producto getOne(Integer id_producto) {
		// TODO Auto-generated method stub
		Tipo_producto resultado = new Tipo_producto();
		String sql = "SELECT * FROM TIPO_PRODUCTO WHERE ID_PRODUCTO = ?";
		try {
        resultado = jdbcTemplate.queryForObject(
                sql, 
                new Object[]{id_producto}, 
                new RowMapper<Tipo_producto>() {
                	public Tipo_producto mapRow(ResultSet rs, int rowNum) throws SQLException {
                		Tipo_producto tipo = new Tipo_producto();
                		tipo.setId_producto(rs.getInt("ID_PRODUCTO"));
                		tipo.setTipo(rs.getString("TIPO"));
                		tipo.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
                		tipo.setFecha_modifica(rs.getDate("FECHA_MODIFICA"));
                		tipo.setUsuario(rs.getString("USUARIO"));
                		tipo.setCantidad_descuento(rs.getInt("CANTIDAD_DESCUENTO"));
                		tipo.setDescuento(rs.getFloat("DESCUENTO"));
                		return tipo;
                	}
                });
        return resultado;
        
		}catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}
	}

	@Override
	public List<Tipo_producto> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TIPO_PRODUCTO");
		sql.append(" WHERE 1 = 1");
		
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Tipo_producto.class));
		
	}

}
