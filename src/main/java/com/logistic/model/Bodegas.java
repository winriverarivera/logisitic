package com.logistic.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bodegas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_bodega;
	private String bodega;
	private String direccion;
	private String usuario_registra;
	private Date fecha_registro;
	private Date fecha_modificacion;

}
