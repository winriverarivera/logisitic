package com.logistic.controller.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.common.ResponseWrapper;
import com.logistic.model.Bodegas;
import com.logistic.model.Logistica_camiones;
import com.logistic.model.RespuestaValidacion;
import com.logistic.service.Logistica_camionesService;

@RestController
@RequestMapping("/logistica_camiones")
public class Logistica_camionesController {
	
	Logger LOG = LoggerFactory.getLogger(BodegasController.class);
	@Autowired
	private Logistica_camionesService data;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseWrapper<Integer> getAll(@RequestBody Logistica_camiones camiones, HttpServletRequest req) {
		ResponseWrapper<Integer> response = new ResponseWrapper<Integer>();
		//RespuestaValidacion validacion = new RespuestaValidacion();
		Integer resultado = new Integer(0);

		// Extraer token
		String token = req.getHeader("Authorization");
		try {
			//validacion = config.validar(token);
			//LOG.info("validacion" + validacion);

			//if (validacion.isValido()) {
				//if (opciones.permiso(validacion.getRol(), "/mantenimientoTipoCedula/save")) {
					resultado = data.save(camiones);
					if(resultado.intValue() > 0) {
						response.setResponse(resultado);						
					}else {
						response.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
						response.setErrorMessage(
								"Error al guardar");
						LOG.error("500 - El registro no se insertó ");
					}					
				//} else {
					//response.setErrorCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
					//response.setErrorMessage(
						//	"Privilegios insuficientes - El usuario no tiene permisos para esta opción");
					//LOG.error("403 - No tiene permiso para esta opción");
				//}
			//} else {
				//response.setErrorCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
				//response.setErrorMessage("Token invalido - iniciar session de nuevo");
				//LOG.error("401 - token invalido");
			//}
		//} catch (ServiceException e) {
		} catch (Exception e) {
			response.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setErrorMessage(e.getMessage());
			LOG.error("500 - " + e);
		}
	    return response;
	 }

	@RequestMapping(value = "/findLogistica_camiones", method = RequestMethod.GET)
	public ResponseWrapper<List<Logistica_camiones>> findLogistica_camiones(HttpServletRequest req) {
		ResponseWrapper<List<Logistica_camiones>> response = new ResponseWrapper<List<Logistica_camiones>>();
		RespuestaValidacion validacion = new RespuestaValidacion();			

		// Extraer token
		String token = req.getHeader("Authorization");
		try {
			//validacion = config.validar(token);
			//LOG.info("validacion" + validacion);

			//if (validacion.isValido()) {
				//if (opciones.permiso(validacion.getRol(), "/mantenimientoUsuario/findUsuarios")) {
					response.setResponse(data.getAll());
				//} else {
					//response.setErrorCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
					//response.setErrorMessage(
					//		"Privilegios insuficientes - El usuario no tiene permisos para esta opción");
					//LOG.error("403 - No tiene permiso para esta opción");
				//}
			//} else {
				//response.setErrorCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
				//response.setErrorMessage("Token invalido - iniciar session de nuevo");
				//LOG.error("401 - token invalido");
			//}
		//} catch (ServiceException e) {
		} catch (Exception e) {
			response.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setErrorMessage(e.getMessage());
			LOG.error("500 - " + e);
		}	
					
	    return response;
	}	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseWrapper<Integer> update(@RequestBody Logistica_camiones camiones, HttpServletRequest req) {
		ResponseWrapper<Integer> response = new ResponseWrapper<Integer>();
		RespuestaValidacion validacion = new RespuestaValidacion();
		
		// Extraer token
				String token = req.getHeader("Authorization");
				try {
					//validacion = config.validar(token);
					LOG.info("validacion" + validacion);

					//if (validacion.isValido()) {
						//if (opciones.permiso(validacion.getRol(), "/mantenimientoUsuario/update")) {
							response.setResponse(data.update(camiones));
						//} else {
							//response.setErrorCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
							//response.setErrorMessage(
							//		"Privilegios insuficientes - El usuario no tiene permisos para esta opción");
							//LOG.error("403 - No tiene permiso para esta opción");
						//}
					//} else {
						//response.setErrorCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
						//response.setErrorMessage("Token invalido - iniciar session de nuevo");
						//LOG.error("401 - token invalido");
					//}
				} catch (Exception e) {//} catch (ServiceException e) {
					response.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
					response.setErrorMessage(e.getMessage());
					LOG.error("500 - " + e);
				}	
				
	    return response;
	 }


}