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

        if ("Despejado".equalsIgnoreCase(data))
        {
            ivEstadoCielo.setImageResource(R.drawable.ic_despejado);
        } else ivEstadoCielo.setImageResource(R.drawable.ic_nuboso);
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
