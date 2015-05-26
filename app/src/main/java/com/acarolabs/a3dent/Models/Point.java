package com.acarolabs.a3dent.Models;


public class Point {
    private long id;
    private String service;
    private String bonus;
    private int points;

    public Point(long id, String service, String bonus, int points) {

        this.id = id;
        this.service = service;
        this.bonus = bonus;
        this.points = points;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
