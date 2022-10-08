package com.logistic.dao;

import java.util.List;

import com.logistic.model.Logistica_maritima;

public interface Logisitica_maritimaDao {
Integer nextVal();	
	
	Integer save(Logistica_maritima data);

	Integer update(Logistica_maritima data);

	Logistica_maritima getOne(Integer id_logistica_maritima);
	
	List<Logistica_maritima> getAll();


}
