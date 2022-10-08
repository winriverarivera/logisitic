package com.logistic.service;

import java.util.List;

import com.logistic.model.Tipo_producto;

public interface Tipo_productoService {

Integer save(Tipo_producto data);
	
	List<Tipo_producto> getAll();
}
