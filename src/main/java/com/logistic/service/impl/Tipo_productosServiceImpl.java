package com.logistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.dao.BodegasDao;
import com.logistic.dao.Tipo_productoDao;
import com.logistic.model.Tipo_producto;
import com.logistic.service.Tipo_productoService;

@Service
public class Tipo_productosServiceImpl implements Tipo_productoService {
	
	@Autowired
	private Tipo_productoDao tipo_productoDao;

	@Override
	public Integer save(Tipo_producto data) {
		// TODO Auto-generated method stub
		return tipo_productoDao.save(data);
	}

	@Override
	public List<Tipo_producto> getAll() {
		// TODO Auto-generated method stub
		return tipo_productoDao.getAll();
	}

	@Override
	public Integer update(Tipo_producto data) {
		// TODO Auto-generated method stub
		return tipo_productoDao.update(data);
	}

}
