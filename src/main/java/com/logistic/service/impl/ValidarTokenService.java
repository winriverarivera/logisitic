package com.logistic.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.logistic.controller.BodegasController;
import com.logistic.model.RespuestaValidacion;

@Service
public class ValidarTokenService {
	
boolean aut = false;
	
	private String secret_token = "08102022";
	private String token_expiration_time = "3600000";
	Logger LOG = LoggerFactory.getLogger(ValidarTokenService.class);
	
	public RespuestaValidacion validar(String token){                  
        aut = false;
        RespuestaValidacion resp = new RespuestaValidacion();
        
        try{
           
           //Algorithm algorithm = Algorithm.HMAC256(System.getProperty("secret.token").trim());
       	 Algorithm algorithm = Algorithm.HMAC256(secret_token);
           JWTVerifier verifier = JWT.require(algorithm).build();
           
           DecodedJWT jwt = verifier.verify(token);
           
           Map<String, Claim> claims = jwt.getClaims();    //Key is the Claim name

           //Claim cc = claims.get("rol");
           //System.out.println("rol "+cc.asString());

               resp.setResultado("token valido");
               //resp.setRol(cc.asString());
               resp.setUsuario(jwt.getIssuer());
               resp.setValido(true);
               LOG.info("resp: "+resp);
               return resp;
                             
        }catch(Exception e){
            resp.setResultado("Token Invalido");
            resp.setValido(false);
            return resp;
        }
    }



}
