package com.example.bodycare.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import com.example.bodycare.R;
import com.example.bodycare.entidades.IMC;


import java.util.ArrayList;
import java.util.List;


public class HistorialListViewAdapter extends ArrayAdapter<IMC> {
    private List<IMC> imcs = new ArrayList<>();
    Context context;
    int resource;

    public HistorialListViewAdapter(Context context, List<IMC> datos){
        super(context, R.layout.listview_historial,datos);
        imcs = datos;
        this.context = context;


    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_historial,null);


        TextView estado = (TextView)item.findViewById(R.id.lblestado);
        estado.setText(imcs.get(position).getEstado());

        TextView peso = (TextView)item.findViewById(R.id.lblpeso);
        peso.setText(imcs.get(position).getPeso());

        TextView imc = (TextView)item.findViewById(R.id.lblimc);
        imc.setText(imcs.get(position).getIMC());

        TextView fecha = (TextView)item.findViewById(R.id.lblfecha);
        fecha.setText(imcs.get(position).getFecha());
        return (item);
    }
}
