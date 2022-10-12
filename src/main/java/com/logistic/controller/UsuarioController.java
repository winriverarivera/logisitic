package com.logistic.controller;

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
import com.logistic.model.RespuestaValidacion;
import com.logistic.model.Usuario;
import com.logistic.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	Logger LOG = LoggerFactory.getLogger(BodegasController.class);
	
	@Autowired
	private UsuarioService data;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseWrapper<Integer> getAll(@RequestBody Usuario usuario, HttpServletRequest req) {
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
					resultado = data.save(usuario);
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

	@RequestMapping(value = "/findUsuarios", method = RequestMethod.GET)
	public ResponseWrapper<List<Usuario>> findUsuarios(HttpServletRequest req) {
		ResponseWrapper<List<Usuario>> response = new ResponseWrapper<List<Usuario>>();
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
	public ResponseWrapper<Integer> update(@RequestBody Usuario usuario, HttpServletRequest req) {
		ResponseWrapper<Integer> response = new ResponseWrapper<Integer>();
		RespuestaValidacion validacion = new RespuestaValidacion();
		
		// Extraer token
				String token = req.getHeader("Authorization");
				try {
					//validacion = config.validar(token);
					LOG.info("validacion" + validacion);

					//if (validacion.isValido()) {
						//if (opciones.permiso(validacion.getRol(), "/mantenimientoUsuario/update")) {
							response.setResponse(data.update(usuario));
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
