package com.acarolabs.a3dent.Models;


public class Point {
    private int id;
    private int service;
    private String notes;
    private int bonus;
    private int points;

    public Point(int id, int service, String notes,int bonus, int points) {

        this.id = id;
        this.service = service;
        this.notes = notes;
        this.bonus = bonus;
        this.points = points;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
