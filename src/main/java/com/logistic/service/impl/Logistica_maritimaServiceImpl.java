package com.logistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.dao.Logisitica_maritimaDao;
import com.logistic.model.Logistica_maritima;
import com.logistic.service.Logistica_maritimaService;

@Service
public class Logistica_maritimaServiceImpl implements Logistica_maritimaService {
	
	@Autowired
	private Logisitica_maritimaDao logistica_maritimaDao;

	@Override
	public Integer save(Logistica_maritima data) {
		// TODO Auto-generated method stub
		return logistica_maritimaDao.save(data);
	}

	@Override
	public Integer update(Logistica_maritima data) {
		// TODO Auto-generated method stub
		return logistica_maritimaDao.update(data);
	}

	@Override
	public List<Logistica_maritima> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//@Autowired
	//private Logisitica_maritimaDao logistica_maritimaDao;
/*
	@Override
	public Integer save(Logistica_maritima data) {
		// TODO Auto-generated method stub
		return logistica_maritimaDao.save(data);
	}

	@Override
	public List<Logistica_maritima> getAll() {
		// TODO Auto-generated method stub
		return logistica_maritimaDao.getAll();
	}

	@Override
	public Integer update(Logistica_maritima data) {
		// TODO Auto-generated method stub
		return logistica_maritimaDao.update(data);
	}
**/
}
