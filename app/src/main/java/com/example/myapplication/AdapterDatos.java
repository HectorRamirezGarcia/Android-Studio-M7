package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatoes> {
    String[] array_noms;

    public AdapterDatos(String[] array_nom){
        this.array_noms = array_noms;
    }

    @Override
    public ViewHolderDatoes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderDatoes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatoes holder, int position) {
        holder.asignarDatos(array_noms[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderDatoes extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderDatoes(@NonNull View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
