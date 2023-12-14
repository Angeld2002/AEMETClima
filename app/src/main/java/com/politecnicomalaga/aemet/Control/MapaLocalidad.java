package com.politecnicomalaga.aemet.Control;

import com.politecnicomalaga.aemet.Model.Localidades;
import com.politecnicomalaga.aemet.R;

import java.util.HashMap;
import java.util.List;

public class MapaLocalidad {
    List<Localidades> listaLocalidad;

    public MapaLocalidad(List<Localidades> listaLocalidad) {
        this.listaLocalidad = listaLocalidad;
    }

    public HashMap<String, String> getMapa() {
        HashMap<String, String> mapaLocalidad = new HashMap<>();
        for (Localidades local : listaLocalidad) {
            mapaLocalidad.put(local.getNombre().toUpperCase(), local.getNumero().toString());
        }
        return mapaLocalidad;
    }

}
