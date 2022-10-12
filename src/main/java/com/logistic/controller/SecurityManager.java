package com.logistic.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.logistic.model.LoginDTO;
import com.logistic.model.MsjLoginDTO;
import com.logistic.model.RespuestaValidacion;
import com.logistic.model.ValidoDTO;

@RestController
@RequestMapping("/security")
public class SecurityManager {
	Logger LOG = LoggerFactory.getLogger(SecurityManager.class);
	
	boolean aut = false;
	
	private String secret_token = "08102022";
	private String token_expiration_time = "3600000";

	/***
	 * 
	 * @param msj MsjLoginDTO
	 * @param request
	 * @return LoginDTO
	 * @throws IllegalArgumentException
	 * @throws UnsupportedEncodingException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
     public LoginDTO autenticar(@RequestBody MsjLoginDTO msj, HttpServletRequest req) throws IllegalArgumentException, UnsupportedEncodingException, ServletException{//, @Context SecurityContext sc) {
		String descripcion = "";
		LoginDTO resp = new LoginDTO();    
        long t =  Long.parseLong(token_expiration_time);//propiedad del servidor que contiene el tiempo de vida del token
            
        try {   
        		//autenticar: usuario, clave
                //req.login(msj.getUsuario().trim(), msj.getClave());
                //resp.setLdapUser(msj.getUsuario().trim());                                
    				
    				Algorithm algorithm = Algorithm.HMAC256(secret_token);
                    String token = JWT.create().withIssuer(msj.getUsuario().trim())
                                      .withClaim("fechaexp", new Date())
                                      .withClaim("rol","PRUEBA")
                                      .withExpiresAt(new Date(System.currentTimeMillis() + t))//.withExpiresAt(new Date(System.currentTimeMillis() + System.getProperty("token.expiration.time"))) 
                                      .sign(algorithm)                                  
                                      ;
                  resp.setEstatus("true");  
                  resp.setLdapUser(msj.getUsuario());
                  resp.setToken(token);  
    			
    			
    			return resp;
    			
        } catch (Exception e) {
        	//LOG.info("Ha ocurrido un error al intentar Login - " + e.getMessage() );
        	System.out.println("Ha ocurrido un error al intentar Login - " + e.getMessage());
        	//e.printStackTrace();
        	resp.setError(e.getMessage());
        	    	return resp;
        }          
    }
	
	
	/**
     * metodo para verificar que el token proporcionado sea valido y la fecha 
     * de expiracion no halla vencido
     * 
     * @param String
     * @return RespuestaValidacion
     */   	
	@RequestMapping(value = "/validar", method = RequestMethod.POST)
    public RespuestaValidacion validar(@RequestBody ValidoDTO token){                  
         aut = false;
         RespuestaValidacion resp = new RespuestaValidacion();
         
         try{
            
            //Algorithm algorithm = Algorithm.HMAC256(System.getProperty("secret.token").trim());
        	 Algorithm algorithm = Algorithm.HMAC256(secret_token);
            JWTVerifier verifier = JWT.require(algorithm).build();
            
            DecodedJWT jwt = verifier.verify(token.getToken());
            
            Map<String, Claim> claims = jwt.getClaims();    //Key is the Claim name
 
            Claim cc = claims.get("rol");
            System.out.println("rol "+cc.asString());

                resp.setResultado("token valido");
                resp.setRol(cc.asString());
                resp.setUsuario(jwt.getIssuer());
                resp.setValido(true);
                return resp;
                              
         }catch(Exception e){
             resp.setResultado("Token Invalido");
             resp.setValido(false);
             return resp;
         }
     }

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
