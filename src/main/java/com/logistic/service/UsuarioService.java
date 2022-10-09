package com.logistic.service;

import java.util.List;


import com.logistic.model.Usuario;


public interface UsuarioService {
	Integer save(Usuario data);
	
	Integer update(Usuario data);
		
	List<Usuario> getAll();

}
