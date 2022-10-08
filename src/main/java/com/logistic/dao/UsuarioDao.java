package com.logistic.dao;

import java.util.List;

import com.logistic.model.Usuario;

public interface UsuarioDao {
Integer nextVal();	
	
	Integer save(Usuario data);

	Integer update(Usuario data);

	Usuario getOne(Integer id_usuario);
	
	List<Usuario> getAll();


}
