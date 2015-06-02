package com.acarolabs.a3dent.Models;

import android.graphics.Bitmap;

import java.net.URL;

/**
 * Created by personal on 21/05/15.
 */
public class Rewards {
    private String beneficios;
    private String puntos;
    private Bitmap imagen;

    public Rewards(String beneficios, String puntos, Bitmap imagen) {

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

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

}
