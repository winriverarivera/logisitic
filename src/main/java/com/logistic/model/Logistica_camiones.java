package com.logistic.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Logistica_camiones implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_logistica_camiones;
	private Integer id_producto;
	private Integer id_bodega;
	private Integer id_usuario;
	private Integer cantidad_producto;	
	private Date fecha_registro;
	private Date fecha_entrega;
	private float precio_envio;
	private String placa_vehiculo;
	private String numero_guia;
	private float descuento;

}
