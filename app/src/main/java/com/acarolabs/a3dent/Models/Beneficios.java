package com.acarolabs.a3dent.Models;

import java.net.URL;

/**
 * Created by personal on 21/05/15.
 */
public class Beneficios {
    private String beneficios;
    private String puntos;
    private String imagen;

    public Beneficios(String beneficios, String puntos, String imagen) {

        this.beneficios = beneficios;
        this.puntos = puntos;
        this.imagen = imagen;
    }
    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
