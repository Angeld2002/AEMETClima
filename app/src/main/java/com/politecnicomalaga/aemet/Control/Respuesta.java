package com.politecnicomalaga.aemet.Control;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.politecnicomalaga.aemet.Model.Clima;

import java.util.LinkedList;
import java.util.List;



public class Respuesta {
    //ESTADO
    protected String datos;
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

    public List<Clima> getDias() {

        LinkedList<Clima> dataList = new LinkedList<>();

        JsonElement jsonElement = JsonParser.parseString(this.datos);
        JsonObject jso;
        JsonArray jsonLista;

        NEW_URL = jsonElement.getAsJsonObject().get("datos").getAsString();
        PeticionLocalidad ptl =new PeticionLocalidad();
        ptl.requestData(NEW_URL);

        jso = jsonElement.getAsJsonObject().get("dataset").getAsJsonObject();
        jsonLista = jso.get("data").getAsJsonArray();
        for (int i = 0; i < jsonLista.size(); i++) {
            //dataList.add(new Clima(jsonLista.get(i).getAsJsonArray().get(0).getAsJsonPrimitive().getAsString(), jsonLista.get(i).getAsJsonArray().get(1).getAsJsonPrimitive().getAsString()));

        }
        return dataList;
    }
}


