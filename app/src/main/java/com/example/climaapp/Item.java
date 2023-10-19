package com.example.climaapp;

public class Item {

    String dataEHora;
    String temperatura;
    String vento;
    String icone;

    public Item(String dataEHora, String temperatura, String vento, String icone) {
        this.dataEHora = dataEHora;
        this.temperatura = temperatura;
        this.vento = vento;
        this.icone = icone;
    }

    public String getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(String dataEHora) {
        this.dataEHora = dataEHora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getVento() {
        return vento;
    }

    public void setVento(String vento) {
        this.vento = vento;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
}
