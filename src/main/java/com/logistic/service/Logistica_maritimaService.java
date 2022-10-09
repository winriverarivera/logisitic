package com.logistic.service;

import java.util.List;


import com.logistic.model.Logistica_maritima;

public interface Logistica_maritimaService {
Integer save(Logistica_maritima data);

Integer update(Logistica_maritima data);
	
	List<Logistica_maritima> getAll();


}
