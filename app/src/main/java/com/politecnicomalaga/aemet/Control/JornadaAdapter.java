package com.politecnicomalaga.aemet.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.politecnicomalaga.aemet.Model.Clima;
import com.politecnicomalaga.aemet.R;

import java.util.LinkedList;

public class JornadaAdapter extends RecyclerView.Adapter<JornadaViewHolder> {

    private final LinkedList<Clima> mList;
    private LayoutInflater mInflater;

    public JornadaAdapter(Context context,
                          LinkedList<Clima> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }


    @NonNull
    @Override
    public JornadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.clima_items,
                parent, false);
        return new JornadaViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull JornadaViewHolder holder, int position) {
        //TODO: fill data
       holder.setEstadoCielo(this.mList.get(position).getEstadoCielo());
       holder.setDia(this.mList.get(position).getNombreDia());
       holder.setTemp(this.mList.get(position).getTemp());
       holder.setHumedad(this.mList.get(position).getHumedad());

    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

}
