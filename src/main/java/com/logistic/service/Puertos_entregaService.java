package com.logistic.service;

import java.util.List;

import com.logistic.model.Puertos_entrega;

public interface Puertos_entregaService {
Integer save(Puertos_entrega data);
	
	List<Puertos_entrega> getAll();


}
