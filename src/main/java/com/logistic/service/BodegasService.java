package com.logistic.service;

import java.util.List;

import com.logistic.model.Bodegas;

public interface BodegasService {
Integer save(Bodegas data);

Integer update(Bodegas data);
	
	List<Bodegas> getAll();

}
