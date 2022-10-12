package com.logistic.model;

import java.io.Serializable;

/**
 *
 * @author moises.rivera
 */
public class MsjLoginDTO implements Serializable{
    private String usuario;
    private String clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "MsjLoginDTO{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 19 * hash + (this.clave != null ? this.clave.hashCode() : 0);
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
        final MsjLoginDTO other = (MsjLoginDTO) obj;
        if ((this.usuario == null) ? (other.usuario != null) : !this.usuario.equals(other.usuario)) {
            return false;
        }
        if ((this.clave == null) ? (other.clave != null) : !this.clave.equals(other.clave)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
