package com.logistic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.logistic.dao.Logisitica_maritimaDao;
import com.logistic.model.Logistica_camiones;
import com.logistic.model.Logistica_maritima;

@Repository
public class Logistica_maritimaDaoImp implements Logisitica_maritimaDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Integer nextVal() {
		// TODO Auto-generated method stub
		Integer id = jdbcTemplate.queryForObject("SELECT max(ID_LOGISTICA_MARITIMA) + 1 FROM LOGISTICA_MARITIMA", Integer.class);
		if(id.equals(null))
			id = 1;
		return id;
	}

	@Override
	public Integer save(Logistica_maritima data) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO LOGISTICA_MARITIMA ( ");
		sql.append("     ID_LOGISTICA_MARITIMA, ");	
		sql.append("     ID_PRODUCTO, ");
		sql.append("     ID_PUERTO, ");
		sql.append("     ID_USUARIO, ");
		sql.append("     CANTIDAD_PRODUCTO, ");
		sql.append("     FECHA_PRODUCTO, ");
		sql.append("     FECHA_ENTREGA, ");
		sql.append("     PRECIO_ENVIO, ");
		sql.append("     NUMERO_FLOTA, ");
		sql.append("     NUMERO_GUIA, ");
		sql.append("     DESCUENTO) ");
		sql.append("  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
		
		return resultado = jdbcTemplate.update(sql.toString(), nextVal(), data.getId_producto(), 				
				data.getId_puerto(), data.getId_usuario(), data.getCantidad_producto(), data.getFecha_producto(),
				data.getFecha_entrega(),data.getPrecio_envio(),data.getNumero_flota(), data.getNumero_guia(),
				data.getDescuento());
	}

	@Override
	public Integer update(Logistica_maritima data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE LOGISTICA_MARITIMA");
        sql.append(" SET CANTIDAD_PRODUCTO             = ?,");
        sql.append("     FECHA_ENTREGA           = ?,");
        sql.append("     PRECIO_ENVIO           = ?,");
        sql.append("     NUMERO_FLOTA           = ?,");
        sql.append("     NUMERO_GUIA           = ?,");        
        sql.append("     DESCUENTO                = ?");               
        sql.append(" WHERE ID_LOGISTICA_MARITIMA = ?");
        return jdbcTemplate.update(sql.toString(), data.getCantidad_producto(),         		 
        		data.getFecha_entrega(), data.getPrecio_envio(), data.getNumero_flota(), data.getNumero_guia(),
        		data.getDescuento(), data.getId_logistica_maritima());
	}

	@Override
	public Logistica_maritima getOne(Integer id_logistica_maritima) {
		// TODO Auto-generated method stub
		Logistica_maritima resultado = new Logistica_maritima();
		String sql = "SELECT * FROM LOGISTICA_MARITIMA WHERE ID_LOGISTICA_MARITIMA = ?";
		try {
        resultado = jdbcTemplate.queryForObject(
                sql, 
                new Object[]{id_logistica_maritima}, 
                new RowMapper<Logistica_maritima>() {
                	public Logistica_maritima mapRow(ResultSet rs, int rowNum) throws SQLException {
                		Logistica_maritima logistica_maritima = new Logistica_maritima();
                		logistica_maritima.setId_logistica_maritima(rs.getInt("ID_LOGISTICA_MARITIMA"));
                		logistica_maritima.setId_producto(rs.getInt("ID_PRODUCTO"));
                		logistica_maritima.setId_puerto(rs.getInt("ID_PUERTO"));
                		logistica_maritima.setId_usuario(rs.getInt("ID_USUARIO"));
                		logistica_maritima.setCantidad_producto(rs.getInt("CANTIDAD_PRODUCTO"));
                		logistica_maritima.setFecha_producto(rs.getDate("FECHA_PRODUCTO"));
                		logistica_maritima.setFecha_entrega(rs.getDate("FECHA_ENTREGA"));
                		logistica_maritima.setPrecio_envio(rs.getFloat("PRECIO_ENVIO"));
                		logistica_maritima.setNumero_flota(rs.getString("NUMERO_FLOTA"));
                		logistica_maritima.setNumero_guia(rs.getString("NUMERO_GUIA"));
                		logistica_maritima.setDescuento(rs.getFloat("DESCUENTO"));
                		return logistica_maritima;
                	}
                });
        return resultado;
        
		}catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}
	}

	@Override
	public List<Logistica_maritima> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM LOGISTICA_MARITIMA");
		sql.append(" WHERE 1 = 1");
		
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Logistica_maritima.class));
	}

}
