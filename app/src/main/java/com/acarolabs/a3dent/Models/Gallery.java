package com.acarolabs.a3dent.Models;

import java.util.Date;

/**
 * Created by ASUS on 02/06/2015.
 */
public class Gallery {
    private long idGallery;
    private String urlGallery;
    private String titleGallery;
    private String descriptionGallery;
    private Date dateTimeGallery;

    public long getIdGallery() {
        return idGallery;
    }

    public void setIdGallery(long idGallery) {
        this.idGallery = idGallery;
    }

    public String getUrlGallery() {
        return urlGallery;
    }

    public void setUrlGallery(String urlGallery) {
        this.urlGallery = urlGallery;
    }

    public String getTitleGallery() {
        return titleGallery;
    }

    public void setTitleGallery(String titleGallery) {
        this.titleGallery = titleGallery;
    }

    public String getDescriptionGallery() {
        return descriptionGallery;
    }

    public void setDescriptionGallery(String descriptionGallery) {
        this.descriptionGallery = descriptionGallery;
    }

    public Date getDateTimeGallery() {
        return dateTimeGallery;
    }

    public void setDateTimeGallery(Date dateTimeGallery) {
        this.dateTimeGallery = dateTimeGallery;
    }


}
