package com.example.bodycare.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodycare.R;
import com.example.bodycare.entidades.Recetas;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterRecetas extends ArrayAdapter<Recetas> {

    private List<Recetas> recetasList = new ArrayList<>();

    public ListViewAdapterRecetas(Context context, List<Recetas> datos) {
        super(context, R.layout.listview_recetas, datos);
        recetasList = datos;

    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_recetas, null);

        TextView nombre = (TextView)item.findViewById(R.id.tvnombre);
        nombre.setText(recetasList.get(position).getNombre());

        TextView descripcion = (TextView)item.findViewById(R.id.tvdescripcion);
        descripcion.setText(recetasList.get(position).getDescripcion());

        ImageView foto = (ImageView)item.findViewById(R.id.fotoreceta);
        foto.setImageResource(recetasList.get(position).getFoto());

        return item;


    }


}
