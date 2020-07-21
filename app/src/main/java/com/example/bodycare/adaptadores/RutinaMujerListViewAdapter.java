package com.example.bodycare.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodycare.R;
import com.example.bodycare.entidades.RutinaMujer;

import java.util.ArrayList;
import java.util.List;

public class RutinaMujerListViewAdapter extends ArrayAdapter<RutinaMujer> {
    private List<RutinaMujer> rutina = new ArrayList<>();
    public RutinaMujerListViewAdapter(Context context, List<RutinaMujer> datos){
        super(context, R.layout.listview_rutinas_mujer, datos);
        rutina = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_rutinas_mujer,null);

        ImageView img = (ImageView)item.findViewById(R.id.imgfotoM);
        img.setImageResource(rutina.get(position).getFoto());
        TextView titulo = (TextView)item.findViewById(R.id.lbltituloM);
        titulo.setText(rutina.get(position).getTitulo());
        TextView descripcion = (TextView)item.findViewById(R.id.lbldescripcionM);
        descripcion.setText(rutina.get(position).getDescripcion());
        TextView idImg = (TextView)item.findViewById(R.id.lblidvideoM);
        idImg.setText(Integer.toString(rutina.get(position).getIdfoto()));
        return (item);
    }



}
