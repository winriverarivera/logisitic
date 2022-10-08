package com.logistic.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Puertos_entrega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_puerto;
	private String puerto;
	private String direccion;
	private String usuario_registro;
	private Date fecha_registro;
	private Date fecha_modifica;


}
