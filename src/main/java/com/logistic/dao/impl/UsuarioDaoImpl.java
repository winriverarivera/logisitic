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

import com.logistic.dao.UsuarioDao;
import com.logistic.model.Tipo_producto;
import com.logistic.model.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Integer nextVal() {
		// TODO Auto-generated method stub
		Integer id = jdbcTemplate.queryForObject("SELECT max(ID_USUARIO) + 1 FROM USUARIO", Integer.class);
		if(id.equals(null))
			id = 1;
		return id;
	}

	@Override
	public Integer save(Usuario data) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO USUARIO ( ");
		sql.append("     ID_USUARIO, ");	
		sql.append("     NOMBRES, ");
		sql.append("     APELLIDOS, ");
		sql.append("     SEXO, ");
		sql.append("     DIRECCION, ");
		sql.append("     TELEFONO1, ");
		sql.append("     TELEFONO2, ");
		sql.append("     FECHA_REGISTRO, ");
		sql.append("     FECHA_MODIFICA, ");
		sql.append("     USUARIO_REGISTRA) ");
		sql.append("  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
		
		return resultado = jdbcTemplate.update(sql.toString(), nextVal(), data.getNombres(), 				
				data.getApellidos(),data.getSexo(), data.getDireccion(), data.getTelefono1(), 
				data.getTelefono2(), data.getFecha_registro(), data.getFecha_modifica(),
				data.getUsuario_registra());
	}

	@Override
	public Integer update(Usuario data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE USUARIO");
        sql.append(" SET NOMBRES             = ?,");
        sql.append("	APELLIDOS             = ?,");
        sql.append("     SEXO           = ?,");
        sql.append("     DIRECCION           = ?,");
        sql.append("     TELEFONO1           = ?,");
        sql.append("     TELEFONO2           = ?,");        
        sql.append("     FECHA_MODIFICA                = ?");               
        sql.append(" WHERE ID_USUARIO = ?");
        return jdbcTemplate.update(sql.toString(), data.getNombres(), data.getApellidos(), data.getSexo(),         		 
        		data.getDireccion(), data.getTelefono1(), data.getTelefono2(), 
        		new Date(), data.getId_usuario());
	}

	@Override
	public Usuario getOne(Integer id_usuario) {
		// TODO Auto-generated method stub
		Usuario resultado = new Usuario();
		String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
		try {
        resultado = jdbcTemplate.queryForObject(
                sql, 
                new Object[]{id_usuario}, 
                new RowMapper<Usuario>() {
                	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                		Usuario usuario = new Usuario();
                		usuario.setId_usuario(rs.getInt("ID_USUARIO"));
                		usuario.setNombres(rs.getString("NOMBRES"));
                		usuario.setApellidos(rs.getString("APELLIDOS"));
                		usuario.setDireccion(rs.getString("DIRECCION"));
                		usuario.setSexo(rs.getString("SEXO"));
                		usuario.setTelefono1(rs.getString("TELEFONO1"));
                		usuario.setTelefono2(rs.getString("TELEFONO2"));
                		usuario.setFecha_modifica(rs.getDate("FECHA_MODIFICA"));
                		usuario.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
                		usuario.setUsuario_registra(rs.getString("USUARIO_REGISTRA"));
                		return usuario;
                	}
                });
        return resultado;
        
		}catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIO");
		sql.append(" WHERE 1 = 1");
		
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Usuario.class));
	}

}
