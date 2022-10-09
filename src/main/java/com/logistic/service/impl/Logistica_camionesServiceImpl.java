package com.logistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.logistic.dao.Logistica_camionesDao;
import com.logistic.model.Logistica_camiones;
import com.logistic.service.Logistica_camionesService;

@Service
public class Logistica_camionesServiceImpl implements Logistica_camionesService {
	
	@Autowired
	private Logistica_camionesDao logistica_camionesDao;

	@Override
	public Integer save(Logistica_camiones data) {
		// TODO Auto-generated method stub
		return logistica_camionesDao.save(data);
	}

	@Override
	public List<Logistica_camiones> getAll() {
		// TODO Auto-generated method stub
		return logistica_camionesDao.getAll();
	}

	@Override
	public Integer update(Logistica_camiones data) {
		// TODO Auto-generated method stub
		return logistica_camionesDao.update(data);
	}
	
	

}
