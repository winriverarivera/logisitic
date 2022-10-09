package com.logistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.dao.UsuarioDao;
import com.logistic.model.Usuario;
import com.logistic.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Integer save(Usuario data) {
		// TODO Auto-generated method stub
		return usuarioDao.save(data);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarioDao.getAll();
	}

	@Override
	public Integer update(Usuario data) {
		// TODO Auto-generated method stub
		return usuarioDao.update(data);
	}

}
