package com.example.climaapp;

public class Item {

    String date;
    String maxTemp;
    String minTemp;
    String wind;

    public Item(String date, String maxTemp, String minTemp, String wind) {
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.wind = wind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
