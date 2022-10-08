package com.logistic.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_usuario;
	private String nombres;
	private String apellidos;
	private String sexo;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String usuario_registra;
	private Date fecha_registro;
	private Date fecha_modifica;

	

}
