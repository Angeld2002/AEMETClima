package com.politecnicomalaga.aemet.Control;

import com.politecnicomalaga.aemet.Model.Localidades;
import com.politecnicomalaga.aemet.R;

import java.util.HashMap;
import java.util.List;

public class MapaLocalidad {
    HashMap<String, String> mapaLocalidad;

    public MapaLocalidad() {
        mapaLocalidad = new HashMap<>();
    }

    public HashMap<String, String> getMapa(List<Localidades> listaLocalidad) {
        mapaLocalidad = new HashMap<>();
        for (Localidades local : listaLocalidad) {
            mapaLocalidad.put(local.getNombre().toUpperCase(), local.getNumero().toString());
        }
        return mapaLocalidad;
    }

}
