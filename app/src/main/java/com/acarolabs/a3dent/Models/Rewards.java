package com.acarolabs.a3dent.Models;

import android.graphics.Bitmap;

/**
 * Created by personal on 21/05/15.
 */
public class Rewards {
    private int idRewards;
    private String nameRewards;
    private int pointsRewards;
    private String descriptionRewards;
   // private Bitmap imagen;
   public Rewards(int idRewards,String nameRewards, String descriptionRewards, int pointsRewards) {
       this.idRewards = idRewards;

       this.nameRewards = nameRewards;
       this.descriptionRewards = descriptionRewards;
       this.pointsRewards = pointsRewards;
       // this.imagen = imagen;
   }

    public String getDescriptionRewards() {
        return descriptionRewards;
    }

    public void setDescriptionRewards(String descriptionRewards) {
        this.descriptionRewards = descriptionRewards;
    }

    public int getIdRewards() {
        return idRewards;
    }

    public void setIdRewards(int idRewards) {
        this.idRewards = idRewards;
    }


    public String getNameRewards() {
        return nameRewards;
    }

    public void setNameRewards(String nameRewards) {
        this.nameRewards = nameRewards;
    }

    public int getPointsRewards() {
        return pointsRewards;
    }

    public void setPointsRewards(int pointsRewards) {
        this.pointsRewards = pointsRewards;
    }

    /*public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }*/

}
