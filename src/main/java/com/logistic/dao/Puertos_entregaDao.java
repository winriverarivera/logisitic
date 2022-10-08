package com.logistic.dao;

import java.util.List;

import com.logistic.model.Puertos_entrega;

public interface Puertos_entregaDao {
Integer nextVal();	
	
	Integer save(Puertos_entrega data);

	Integer update(Puertos_entrega data);

	Puertos_entrega getOne(Integer id_puerto_entrega);
	
	List<Puertos_entrega> getAll();


}
