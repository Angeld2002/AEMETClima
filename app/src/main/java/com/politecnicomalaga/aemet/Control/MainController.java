package com.politecnicomalaga.aemet.Control;

import com.politecnicomalaga.aemet.Model.Clima;
import com.politecnicomalaga.aemet.View.MainActivity;

import java.util.LinkedList;
import java.util.List;

public class MainController {

    //SINGLETON Controller
    private static String DATA_URL;
    private static String DATA_CODMUN;
    private static MainController mySingleController;

    private List<Clima> dataRequested;
    private static MainActivity activeActivity;
    //Comportamiento
    //Constructor
    private MainController() {
         dataRequested = new LinkedList<Clima>();
    }

    public static void setURL() {
        DATA_URL = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/";
    }
    public static void setCodigo(String codigo) {
        DATA_CODMUN = codigo;
    }
    //Get instance
    public static MainController getSingleton() {
        if (MainController.mySingleController == null) {
            mySingleController = new MainController();
        }
        return mySingleController;
    }

    //To send data to view
    public List<Clima> getDataFromAemet() {
        return this.dataRequested;
    }

    public static String getDataUrl() {
        return DATA_URL;
    }
    //Called from the view
    public void requestDataFromAemet() {
        Peticion p = new Peticion();
        p.requestData(DATA_URL+DATA_CODMUN);
    }

    //Called when onResponse is OK
    public void setDataFromAemet(String json) {

        Respuesta answer = new Respuesta(json);
        dataRequested = answer.getDias();
        //Load data on the list
        MainController.activeActivity.accessData();
    }

    public void setErrorFromAemet(String error) {

        //Load data on the list
        MainController.activeActivity.errorData(error);
    }


    public static void setActivity(MainActivity myAct) {
        activeActivity = myAct;
    }

}
