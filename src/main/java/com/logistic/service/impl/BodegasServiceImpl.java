package com.logistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.dao.BodegasDao;
import com.logistic.model.Bodegas;
import com.logistic.service.BodegasService;


@Service
public class BodegasServiceImpl implements BodegasService {
	
	@Autowired
	private BodegasDao bodegasDao;

	@Override
	public Integer save(Bodegas data) {
		// TODO Auto-generated method stub
		return bodegasDao.save(data);
	}

	@Override
	public List<Bodegas> getAll() {
		// TODO Auto-generated method stub
		return bodegasDao.getAll();
	}

	@Override
	public Integer update(Bodegas data) {
		// TODO Auto-generated method stub
		return bodegasDao.update(data);
	}

}
