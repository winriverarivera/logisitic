package com.logistic.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tipo_producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_producto;
	private String tipo;
	private Date fecha_registro;
	private Date fecha_modifica;
	private String usuario;
	private Integer cantidad_descuento;
	private float descuento;
}
