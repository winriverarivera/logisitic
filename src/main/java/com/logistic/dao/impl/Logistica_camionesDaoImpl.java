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

import com.logistic.dao.Logistica_camionesDao;

import com.logistic.model.Logistica_camiones;

@Repository
public class Logistica_camionesDaoImpl implements Logistica_camionesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Integer nextVal() {
		// TODO Auto-generated method stub
		Integer id = jdbcTemplate.queryForObject("SELECT max(ID_LOGISTICA_CAMIONES) + 1 FROM LOGISTICA_CAMIONES", Integer.class);
		if(id.equals(null))
			id = 1;
		return id;
	}

	@Override
	public Integer save(Logistica_camiones data) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO LOGISTICA_CAMIONES ( ");
		sql.append("     ID_LOGISTICA_CAMIONES, ");	
		sql.append("     ID_PRODUCTO, ");	
		sql.append("     ID_BODEGA, ");	
		sql.append("     ID_USUARIO, ");	
		sql.append("     CANTIDAD_PRODUCTO, ");
		sql.append("     FECHA_REGISTRO, ");
		sql.append("     FECHA_ENTREGA, ");		
		sql.append("     PRECIO_ENVIO, ");	
		sql.append("     PLACA_VEHICULO, ");	
		sql.append("     NUMERO_GUIA, ");
		sql.append("     DESCUENTO) ");
		sql.append("  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
		
		return resultado = jdbcTemplate.update(sql.toString(), nextVal(), data.getId_producto(), 				
				data.getId_bodega(), data.getId_usuario(), data.getCantidad_producto(),
				data.getFecha_registro(), data.getFecha_entrega(), data.getPrecio_envio(),
				data.getPlaca_vehiculo(), data.getNumero_guia(), data.getDescuento());
	}

	@Override
	public Integer update(Logistica_camiones data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE LOGISTICA_CAMIONES");
        sql.append(" SET CANTIDAD_PRODUCTO             = ?,");
        sql.append("     FECHA_ENTREGA           = ?,");
        sql.append("     PRECIO_ENVIO           = ?,");
        sql.append("     PLACA_VEHICULO           = ?,");
        sql.append("     NUMERO_GUIA           = ?,");        
        sql.append("     DESCUENTO                = ?");               
        sql.append(" WHERE ID_LOGISTICA_CAMIONES = ?");
        return jdbcTemplate.update(sql.toString(), data.getCantidad_producto(),         		 
        		data.getFecha_entrega(), data.getPrecio_envio(), data.getPlaca_vehiculo(), data.getNumero_guia(),
        		data.getDescuento(), data.getId_logistica_camiones());
	}

	@Override
	public Logistica_camiones getOne(Integer id_logistica_camiones) {
		// TODO Auto-generated method stub
		Logistica_camiones resultado = new Logistica_camiones();
		String sql = "SELECT * FROM LOGISTICA_CAMIONES WHERE ID_LOGISTICA_CAMIONES = ?";
		try {
        resultado = jdbcTemplate.queryForObject(
                sql, 
                new Object[]{id_logistica_camiones}, 
                new RowMapper<Logistica_camiones>() {
                	public Logistica_camiones mapRow(ResultSet rs, int rowNum) throws SQLException {
                		Logistica_camiones logistica_camiones = new Logistica_camiones();
                		logistica_camiones.setId_logistica_camiones(rs.getInt("ID_LOGISTICA_CAMIONES"));
                		logistica_camiones.setId_producto(rs.getInt("ID_PRODUCTO"));
                		logistica_camiones.setId_bodega(rs.getInt("ID_BODEGA"));
                		logistica_camiones.setId_usuario(rs.getInt("ID_USUARIO"));
                		logistica_camiones.setCantidad_producto(rs.getInt("CANTIDAD_PRODUCTO"));
                		logistica_camiones.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
                		logistica_camiones.setFecha_entrega(rs.getDate("FECHA_ENTREGA"));
                		logistica_camiones.setPrecio_envio(rs.getFloat("PRECIO_ENVIO"));
                		logistica_camiones.setPlaca_vehiculo(rs.getString("PLACA_VEHICULO"));
                		logistica_camiones.setNumero_guia(rs.getString("NUMERO_GUIA"));
                		logistica_camiones.setDescuento(rs.getFloat("DESCUENTO"));
                		return logistica_camiones;
                	}
                });
        return resultado;
        
		}catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}
	}

	@Override
	public List<Logistica_camiones> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM LOGISTICA_CAMIONES");
		sql.append(" WHERE 1 = 1");
		
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Logistica_camiones.class));
	}

}
