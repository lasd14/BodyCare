package com.example.bodycare.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodycare.R;
import com.example.bodycare.entidades.Receta;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecetasListViewAdapter extends ArrayAdapter<Receta> {
    private List<Receta> recetasC = new ArrayList<>();
    Context context;
    int resource;

    public RecetasListViewAdapter(Context context, List<Receta> datos){
        super(context, R.layout.listview_recetas,datos);
        recetasC = datos;
        this.context = context;


    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_recetas,null);


        ImageView img = (ImageView)item.findViewById(R.id.imgfoto);
        Picasso.get().load(String.valueOf(recetasC.get(position).getImagen())).resize(100,100).into(img);


        TextView titulo = (TextView)item.findViewById(R.id.lbltitulo);
        titulo.setText(recetasC.get(position).getTitulo());

        TextView descripcion = (TextView)item.findViewById(R.id.lbldescripcion);
        descripcion.setText(recetasC.get(position).getDescripcion());
        return (item);
    }
}
