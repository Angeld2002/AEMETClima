package com.politecnicomalaga.aemet.Control;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.politecnicomalaga.aemet.Model.Clima;

import java.util.LinkedList;


public class Respuesta {
    //ESTADO
    protected String datos;
    protected String datosClima;

    public void setDatosClima(String datosClima) {
        this.datosClima = datosClima;
    }

    String NEW_URL;


    //COMPORTAMIENTO
    public Respuesta(String entrada) {
        datos = entrada;
    }
    public void getlink() {

        LinkedList<Clima> dataList = new LinkedList<>();

        JsonElement jsonElement = JsonParser.parseString(this.datos);
        JsonObject jso;
        JsonArray jsonLista;

         NEW_URL = jsonElement.getAsJsonObject().get("datos").getAsString();
        PeticionLocalidad ptl =new PeticionLocalidad();
        ptl.requestData(NEW_URL);


        }

    public void getDias() {

        LinkedList<Clima> dataList = new LinkedList<>();

        Log.d("Respuesta",this.datos);
        JsonObject jso = JsonParser.parseString(this.datos).getAsJsonObject();

        NEW_URL = jso.get("datos").getAsString();
        PeticionLocalidad ptl =new PeticionLocalidad();
        ptl.requestData(NEW_URL);
    }
    public void getClima() {
        JsonArray jsa = JsonParser.parseString(this.datosClima).getAsJsonArray();
        Log.d("Respuesta",this.datosClima);
        JsonObject jsonCompleto = jsa.get(0).getAsJsonObject();
        JsonObject jsonPre = jsonCompleto.getAsJsonObject("prediccion");
        JsonArray jsaDia = jsonPre.getAsJsonArray("dia");
        for (int i = 0; i < jsonCompleto.size(); i++) {
            //dataList.add(new Clima(jsonLista.get(i).getAsJsonArray().get(0).getAsJsonPrimitive().getAsString(), jsonLista.get(i).getAsJsonArray().get(1).getAsJsonPrimitive().getAsString()));

        }
    }
}


