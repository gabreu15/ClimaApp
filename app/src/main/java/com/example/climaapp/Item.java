package com.example.climaapp;

public class Item {

    String time;
    String temperature;
    int image;

    public Item(String time, String temperature, int image) {
        this.time = time;
        this.temperature = temperature;
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
