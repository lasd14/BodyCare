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
    private List<RutinaHombre> rutinaHombres = new ArrayList<>();
    Context context;


    public RutinaHombreListViewAdapter(Context context, List<RutinaHombre> datos){
        super(context, R.layout.listview_rutinas_hombre,datos);

    }

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_recetas,null);


        ImageView img = (ImageView)item.findViewById(R.id.imgfoto);
        img.setImageResource(rutinaHombres.get(position).getFoto());


        TextView titulo = (TextView)item.findViewById(R.id.lbltitulo);
        titulo.setText(rutinaHombres.get(position).getTitulo());

        TextView descripcion = (TextView)item.findViewById(R.id.lbldescripcion);
        descripcion.setText(rutinaHombres.get(position).getDescripcion());
        return (item);


    }





}
