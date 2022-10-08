package com.logistic.dao;

import java.util.List;

import com.logistic.model.Logistica_camiones;

public interface Logistica_camionesDao {
Integer nextVal();	
	
	Integer save(Logistica_camiones data);

	Integer update(Logistica_camiones data);

	Logistica_camiones getOne(Integer id_logistica_camiones);
	
	List<Logistica_camiones> getAll();


}
