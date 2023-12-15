package com.politecnicomalaga.aemet.Control;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.aemet.R;


public class JornadaViewHolder extends RecyclerView.ViewHolder {

    //ESTADO

    //TODO: declare attributes to hold two textviews, day and money
    final JornadaAdapter mAdapter;
    private ImageView ivEstadoCielo;
    private TextView tvDia;
    private TextView tvTemp;
    private TextView tvHumedad;


    //COMPORTAMIENTO
    public JornadaViewHolder(View itemView, JornadaAdapter adapter) {
        super(itemView);
        ivEstadoCielo = itemView.findViewById(R.id.ivEstadoCielo);
        tvDia = itemView.findViewById(R.id.tvDia);
        tvTemp = itemView.findViewById(R.id.tvTemp);
        tvHumedad = itemView.findViewById(R.id.tvHumedad);
        this.mAdapter = adapter;
    }

    public void setEstadoCielo(String data) {

        if ("Despejado".equalsIgnoreCase(data)) {
            ivEstadoCielo.setImageResource(R.drawable.ic_despejado);
        } else if ("Poco nuboso".equalsIgnoreCase(data) || "Intervalos nubosos".equalsIgnoreCase(data) ) {
            ivEstadoCielo.setImageResource(R.drawable.ic_poco_nuboso);
        } else if ("Nuboso".equalsIgnoreCase(data) || "Muy nuboso".equalsIgnoreCase(data) || "Cubierto".equalsIgnoreCase(data) ) {
            ivEstadoCielo.setImageResource(R.drawable.ic_nuboso);
        } else if ("Cubierto con lluvia".equalsIgnoreCase(data) ||"Cubierto con lluvia".equalsIgnoreCase(data) || "Cubierto con lluvia escasa".equalsIgnoreCase(data) ) {
            ivEstadoCielo.setImageResource(R.drawable.ic_lluvioso);
        } else if ("Poco nuboso".equalsIgnoreCase(data)) {
            ivEstadoCielo.setImageResource(R.drawable.ic_nuboso);
        } else if ("Poco nuboso".equalsIgnoreCase(data)) {
            ivEstadoCielo.setImageResource(R.drawable.ic_nuboso);
        } else {
            ivEstadoCielo.setImageResource(R.drawable.ic_despejado);
        }
    }
    public void setDia(String data) {
        tvDia.setText(data);
    }
    public void setTemp(String data) {
        tvTemp.setText(data);
    }
    public void setHumedad(String data) {
        tvHumedad.setText(data);
    }
}
