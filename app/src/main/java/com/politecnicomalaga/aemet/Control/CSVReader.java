package com.politecnicomalaga.aemet.Control;

import android.content.Context;
import android.content.res.Resources;

import com.politecnicomalaga.aemet.Model.Localidades;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Localidades> readCSV(Context context, int resourceId) {
        List<Localidades> listaLocalidad = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(resourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] Parte = line.split(",");
                Localidades NuevaLocalidad = new Localidades(Parte[0]+Parte[1],Parte[2]);
                listaLocalidad.add(NuevaLocalidad);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaLocalidad;
    }
}
