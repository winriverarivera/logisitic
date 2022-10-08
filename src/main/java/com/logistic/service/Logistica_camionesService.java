package com.logistic.service;

import java.util.List;

import com.logistic.model.Logistica_camiones;

public interface Logistica_camionesService {
Integer save(Logistica_camiones data);
	
	List<Logistica_camiones> getAll();


}
