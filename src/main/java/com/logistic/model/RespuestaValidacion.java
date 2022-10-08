package com.logistic.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author moises.rivera
 */
public class RespuestaValidacion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private boolean valido;
    private String Resultado;
    private String usuario;
    private String rol;

    @Override
    public String toString() {
        return "{" + "valido=" + valido + ", Resultado=" + Resultado + ", usuario=" + usuario + ", rol=" + rol + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.valido ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.Resultado);
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.rol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RespuestaValidacion other = (RespuestaValidacion) obj;
        if (this.valido != other.valido) {
            return false;
        }
        if (!Objects.equals(this.Resultado, other.Resultado)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    
}
