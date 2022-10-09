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

import com.logistic.dao.Puertos_entregaDao;

import com.logistic.model.Puertos_entrega;

@Repository
public class Puertos_entregaDaoImpl implements Puertos_entregaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer nextVal() {
		// TODO Auto-generated method stub
		Integer id = jdbcTemplate.queryForObject("SELECT max(ID_PUERTO) + 1 FROM PUERTOS_ENTREGA", Integer.class);
		if(id.equals(null))
			id = 1;
		return id;
	}

	@Override
	public Integer save(Puertos_entrega data) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO PUERTOS_ENTREGA ( ");
		sql.append("     ID_PUERTO, ");	
		sql.append("     PUERTO, ");
		sql.append("     DIRECCION, ");
		sql.append("     USUARIO_REGISTRO, ");				
		sql.append("     FECHA_REGISTRO) ");
		sql.append("  VALUES (?, ?, ?, ?, ?)");
				
		
		return resultado = jdbcTemplate.update(sql.toString(), nextVal(), data.getPuerto(), 				
				data.getDireccion(), data.getUsuario_registro(), data.getFecha_registro());
	}

	@Override
	public Integer update(Puertos_entrega data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE PUERTOS_ENTREGA");
        sql.append(" SET DIRECCION             = ?,");
        sql.append("     USUARIO_REGISTRO           = ?,");
        sql.append("     FECHA_MODIFICA                = ?");               
        sql.append(" WHERE ID_PUERTO = ?");
        
        return jdbcTemplate.update(sql.toString(), data.getDireccion(),         		 
        		data.getUsuario_registro(),
        		new Date(),
        		data.getId_puerto());
	}

	@Override
	public Puertos_entrega getOne(Integer id_puerto) {
		// TODO Auto-generated method stub
		Puertos_entrega resultado = new Puertos_entrega();
		String sql = "SELECT * FROM PUERTOS_ENTREGA WHERE ID_PUERTO = ?";
		try {
        resultado = jdbcTemplate.queryForObject(
                sql, 
                new Object[]{id_puerto}, 
                new RowMapper<Puertos_entrega>() {
                	public Puertos_entrega mapRow(ResultSet rs, int rowNum) throws SQLException {
                		Puertos_entrega puerto = new Puertos_entrega();
                		puerto.setId_puerto(rs.getInt("ID_PUERTO"));
                		puerto.setPuerto(rs.getString("PUERTO"));
                		puerto.setDireccion(rs.getString("DIRECCION"));
                		puerto.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
                		puerto.setFecha_modifica(rs.getDate("FECHA_MODIFICA"));
                		puerto.setUsuario_registro(rs.getString("USUARIO_REGISTRO"));                		
                		return puerto;
                	}
                });
        return resultado;
        
		}catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}

	}

	@Override
	public List<Puertos_entrega> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM PUERTOS_ENTREGA");
		sql.append(" WHERE 1 = 1");
		
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Puertos_entrega.class));
	}

}
