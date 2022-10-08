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

import com.logistic.dao.BodegasDao;
import com.logistic.model.Bodegas;



@Repository
public class BodegasDaoImpl implements BodegasDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Integer nextVal() {
		// TODO Auto-generated method stub
		Integer id = jdbcTemplate.queryForObject("SELECT max(ID_BODEGA) + 1 FROM BODEGAS", Integer.class);
		if(id.equals(null))
			id = 1;
		return id;
	}

	@Override
	public Integer save(Bodegas data) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO BODEGAS ( ");
		sql.append("     ID_BODEGA, ");	
		sql.append("     BODEGA, ");
		sql.append("     DIRECCION, ");
		sql.append("     USUARIO_REGISTRA, ");				
		sql.append("     FECHA_REGISTRO) ");
		sql.append("  VALUES (?, ?, ?, ?, ?)");
				
		
		return resultado = jdbcTemplate.update(sql.toString(), nextVal(), data.getBodega(), 				
				data.getDireccion(), data.getUsuario_registra(), data.getFecha_registro());
	}

	@Override
	public Integer update(Bodegas data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE BODEGAS");
        sql.append(" SET DIRECCION             = ?,");
        sql.append("     USUARIO_REGISTRA           = ?,");
        sql.append("     FECHA_MODIFICA                = ?");               
        sql.append(" WHERE ID_BODEGA = ?");
        return jdbcTemplate.update(sql.toString(), data.getDireccion(),         		 
        		data.getUsuario_registra(),
        		new Date(),
        		data.getId_bodega());
	}

	@Override
	public Bodegas getOne(Integer id_bodega) {
		// TODO Auto-generated method stub
		Bodegas resultado = new Bodegas();
		String sql = "SELECT * FROM BODEGAS WHERE ID_BODEGA = ?";
		try {
        resultado = jdbcTemplate.queryForObject(
                sql, 
                new Object[]{id_bodega}, 
                new RowMapper<Bodegas>() {
                	public Bodegas mapRow(ResultSet rs, int rowNum) throws SQLException {
                		Bodegas bodega = new Bodegas();
                		bodega.setId_bodega(rs.getInt("ID_BODEGA"));
                		bodega.setBodega(rs.getString("BODEGA"));
                		bodega.setDireccion(rs.getString("DIRECCION"));
                		bodega.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
                		bodega.setFecha_modificacion(rs.getDate("FECHA_MODIFICACION"));
                		bodega.setUsuario_registra(rs.getString("USUARIO_REGISTRA"));                		
                		return bodega;
                	}
                });
        return resultado;
        
		}catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}
	}

	@Override
	public List<Bodegas> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM BODEGAS");
		sql.append(" WHERE 1 = 1");
		
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Bodegas.class));
		
	}

}
