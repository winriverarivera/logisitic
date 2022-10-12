/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logistic.model;

public class LoginDTO {
	String roles;
	//String usrCod;
	String ldapUser;
	//String userDn;
	String estatus;
	String token;
	String error;
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	/*public String getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}*/

	public String getLdapUser() {
		return ldapUser;
	}

	public void setLdapUser(String ldapUser) {
		this.ldapUser = ldapUser;
	}
/*
	public String getUserDn() {
		return userDn;
	}

	public void setUserDn(String userDn) {
		this.userDn = userDn;
	}
*/
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}