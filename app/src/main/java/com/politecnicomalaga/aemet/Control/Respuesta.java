package com.politecnicomalaga.aemet.Control;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.politecnicomalaga.aemet.Model.Clima;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;


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

    public void getDias() {



        Log.d("Respuesta",this.datos);
        JsonObject jso = JsonParser.parseString(this.datos).getAsJsonObject();

        NEW_URL = jso.get("datos").getAsString();
        PeticionLocalidad ptl =new PeticionLocalidad();
        ptl.requestData(NEW_URL);
    }
    public LinkedList<Clima> getClima() {

        LinkedList<Clima> dataList = new LinkedList<>();

        JsonArray jsa = JsonParser.parseString(this.datosClima).getAsJsonArray();
        Log.d("Respuesta",this.datosClima);
        JsonObject jsonCompleto = jsa.get(0).getAsJsonObject();
        JsonObject jsonPre = jsonCompleto.getAsJsonObject("prediccion");
        JsonArray jsaDia = jsonPre.getAsJsonArray("dia");
        for (int i = 0; i < jsaDia.size(); i++) {
            JsonObject diaElement = jsaDia.get(i).getAsJsonObject();

            String fecha = diaElement.get("fecha").getAsString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            LocalDateTime fechaLocalDateTime = LocalDateTime.parse(fecha, formatter);
            DateTimeFormatter formatterDiaSemana = DateTimeFormatter.ofPattern("EEEE", new Locale("es", "ES"));
            String diaSemana = fechaLocalDateTime.format(formatterDiaSemana);

            JsonArray jsaEstadoCielo = diaElement.getAsJsonArray("estadoCielo");
            JsonObject estadoCieloElement = jsaEstadoCielo.get(0).getAsJsonObject();
            String estadoCielo = estadoCieloElement.get("descripcion").getAsString();
            Log.d("Respuesta Estados", estadoCielo);

            JsonObject tempElement = diaElement.getAsJsonObject("temperatura");
            String tempMax = tempElement.get("maxima").getAsString();
            String tempMin = tempElement.get("minima").getAsString();

            JsonObject humElement = diaElement.getAsJsonObject("humedadRelativa");
            String humMax = tempElement.get("maxima").getAsString();
            String humMin = tempElement.get("minima").getAsString();
            if (i == 0) {
                dataList.add(new Clima(estadoCielo,"Hoy",diaSemana,tempMax, tempMin,humMax,humMin));
            } else if (i == 1) {
                dataList.add(new Clima(estadoCielo,"Mañana",diaSemana,tempMax, tempMin,humMax,humMin));
            } else {
                dataList.add(new Clima(estadoCielo,diaSemana,tempMax, tempMin,humMax,humMin));
            }
        }
        return dataList;
    }
}



