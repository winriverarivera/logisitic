package com.logistic.common;

public enum EnumDriverBD {

	ORACLEJDBCORACLEDRIVER("oracle.jdbc.OracleDriver"),
	COMMICROSOFTSQLSERVERJDBCSQLSERVERDRIVER("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
	COMMYSQLCJJDBCDRIVER("com.mysql.jdbc.Driver");//COMMYSQLCJJDBCDRIVER

	private String nombre;
	
	EnumDriverBD(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
        return nombre;
    }
	
	public String getDB( ) {
		switch (this) {
		    case ORACLEJDBCORACLEDRIVER:
		        return "ORA";
		    case COMMICROSOFTSQLSERVERJDBCSQLSERVERDRIVER:
		        return "MSSQL";
		    case COMMYSQLCJJDBCDRIVER:
		    	return "MYSQL";
		    default:
		        return "";
		}
	}
	
}