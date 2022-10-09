package com.logistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.logistic.dao.Puertos_entregaDao;
import com.logistic.model.Puertos_entrega;
import com.logistic.service.Puertos_entregaService;

@Service
public class Puertos_entregaServiceImpl implements Puertos_entregaService {
	@Autowired
	private Puertos_entregaDao puertos_entregaDao;

	@Override
	public Integer save(Puertos_entrega data) {
		// TODO Auto-generated method stub
		return puertos_entregaDao.save(data);
	}

	@Override
	public List<Puertos_entrega> getAll() {
		// TODO Auto-generated method stub
		return puertos_entregaDao.getAll();
	}

	@Override
	public Integer update(Puertos_entrega data) {
		// TODO Auto-generated method stub
		return puertos_entregaDao.update(data);
	}

}
