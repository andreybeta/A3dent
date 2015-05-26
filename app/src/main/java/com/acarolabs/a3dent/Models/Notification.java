package com.acarolabs.a3dent.Models;

/**
 * Created by ASUS on 25/05/2015.
 */
public class Notification {
    public String getTitleNotification() {
        return titleNotification;
    }

    public void setTitleNotification(String titleNotification) {
        this.titleNotification = titleNotification;
    }

    public String getDescriptionNotification() {
        return descriptionNotification;
    }

    public void setDescriptionNotification(String descriptionNotification) {
        this.descriptionNotification = descriptionNotification;
    }

    private String titleNotification;
    private String descriptionNotification;
}
