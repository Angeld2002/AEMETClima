package com.politecnicomalaga.aemet.Model;

public class Localidades {
    private String numero;
    private String nombre;

    public Localidades(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
}
