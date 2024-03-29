package com.example.bodycare.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodycare.R;
import java.util.ArrayList;
import java.util.List;
import com.example.bodycare.entidades.RutinaHombre;

import java.util.ArrayList;
import java.util.List;

public class RutinaHombreListViewAdapter extends ArrayAdapter<RutinaHombre> {
    private List<RutinaHombre> rutinas = new ArrayList<>();



    public RutinaHombreListViewAdapter(Context context, List<RutinaHombre> datos){
        super(context, R.layout.listview_rutinas_hombre,datos);
        rutinas = datos;

    }

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_rutinas_hombre,null);


        ImageView img = (ImageView)item.findViewById(R.id.imgfoto);
        img.setImageResource(rutinas.get(position).getFoto());


        TextView titulo = (TextView)item.findViewById(R.id.lbltitulo);
        titulo.setText(rutinas.get(position).getTitulo());

        TextView descripcion = (TextView)item.findViewById(R.id.lbldescripcion);
        descripcion.setText(rutinas.get(position).getDescripcion());

        TextView idvideo = (TextView)item.findViewById(R.id.lblidvideo);
        idvideo.setText(Integer.toString( rutinas.get(position).getIdeVideo()  ));

        return (item);


    }





}
