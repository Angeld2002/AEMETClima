package com.politecnicomalaga.aemet.Model;

public class Clima {

    //Aunque sabemos que precios es un double, lo guardamos en String porque nos llega en String
    //y se muestra como texto, al fin y al cabo

    //POJO CLASS
    private String estadoCielo;
    private String dia;
    private String nombreDia;
    private String tempMax;
    private String tempMin;
    private String humedadMax;
    private String humedadMin;
    //Comportamiento
    //Construtor

    public Clima(String estadoCielo,String nombreDia, String tempMax, String tempMin, String humedadMax, String humedadMin) {
        this.estadoCielo = estadoCielo;
        this.nombreDia = nombreDia;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.humedadMax = humedadMax;
        this.humedadMin = humedadMin;
    }
    public Clima(String estadoCielo,String dia, String nombreDia, String tempMax, String tempMin, String humedadMax, String humedadMin) {
        this.estadoCielo = estadoCielo;
        this.dia = dia;
        this.nombreDia = nombreDia;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.humedadMax = humedadMax;
        this.humedadMin = humedadMin;
    }


    //Getters



}
