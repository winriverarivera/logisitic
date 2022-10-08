package com.logistic.dao;

import java.util.List;

import com.logistic.model.Tipo_producto;

public interface Tipo_productoDao {

	Integer nextVal();	
	
	Integer save(Tipo_producto data);

	Integer update(Tipo_producto data);

	Tipo_producto getOne(Integer id_tipo_producto);
	
	List<Tipo_producto> getAll();

}
