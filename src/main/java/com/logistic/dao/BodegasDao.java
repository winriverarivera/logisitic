package com.logistic.dao;

import java.util.List;

import com.logistic.model.Bodegas;

public interface BodegasDao {
Integer nextVal();	
	
	Integer save(Bodegas data);

	Integer update(Bodegas data);

	Bodegas getOne(Integer id_bodegas);
	
	List<Bodegas> getAll();


}
