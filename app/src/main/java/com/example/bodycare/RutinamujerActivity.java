package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodycare.adaptadores.RutinaMujerListViewAdapter;
import com.example.bodycare.entidades.RutinaMujer;

import java.util.ArrayList;
import java.util.List;

public class RutinamujerActivity extends AppCompatActivity {

    ListView lstSf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinamujer);

        lstSf = (ListView)findViewById(R.id.lstSF);
        this.LoasList();
        OnListItemEvents();


    }


    public void LoasList(){

        List<RutinaMujer> rutinas = new ArrayList<>();
        rutinas.add(new RutinaMujer(R.drawable.rutina1, "Rutina 1", "La tendencia «30 Days Squat Challenge» ha dado mucho que hablar, pero muchos se preguntan si realmente es posible adelgazar solo con sentadillas.", 1));
        rutinas.add(new RutinaMujer(R.drawable.rutina2, "Rutina 2", "Ahora lo tienes claro, las sentadillas por sí solas no bastan para perder peso, en cambio, son excelentes para reafirmar y fortalecer el tren inferior.", 2));
        rutinas.add(new RutinaMujer(R.drawable.rutina3, "Rutina 3", "La sentadilla o cuclilla es uno de los ejercicios básicos del entrenamiento de fuerza. Trabaja directamente los músculos de muslo, músculos de la cadera y glúteos", 3));
        rutinas.add(new RutinaMujer(R.drawable.rutina4, "Rutina 4", "Este ejercicio se centra principalmente en los muslos (cuádriceps e isquiotibiales) y los glúteos, pero también trabaja la fuerza y la estabilidad del core, la movilidad de los tobillos y los músculos de la espalda, entre otros.", 4));
        RutinaMujerListViewAdapter adapter = new RutinaMujerListViewAdapter(getApplicationContext(),rutinas);
        lstSf.setAdapter(adapter);

    }



    public void OnListItemEvents(){
        lstSf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),VideoRutinaMujer.class);

                //Enviamos la información con un putextra
                String titulo = ((RutinaMujer)parent.getItemAtPosition(position)).getTitulo();
                i.putExtra("titulo",titulo);

                String Descripcion = ((RutinaMujer)parent.getItemAtPosition(position)).getDescripcion();
                i.putExtra("descripcion",Descripcion);


                int idvideo = ((RutinaMujer)parent.getItemAtPosition(position)).getIdfoto();
                i.putExtra("video",idvideo);



                Toast.makeText(getApplicationContext(),"Selecciono: " + idvideo,Toast.LENGTH_LONG).show();
                startActivity(i);

            }
        });
    }


}