package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.bodycare.adaptadores.RutinaHombreListViewAdapter;
import com.example.bodycare.entidades.RutinaHombre;
import com.example.bodycare.entidades.RutinaMujer;

import java.util.ArrayList;
import java.util.List;

public class RutinashombreActivity extends AppCompatActivity {
    ListView lstSF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinashombre);

        lstSF = (ListView)findViewById(R.id.lstSF);
        this.LoadList();
        OnListItemEvents();
    }





    private void LoadList(){

        List<RutinaHombre> rutinas = new ArrayList<>();
        rutinas.add(new RutinaHombre(R.drawable.rutina1, "Rutina 1","Como quedo la tarea",1));
        rutinas.add(new RutinaHombre(R.drawable.rutina1,"Rutina 2","Te llego el mensaje que te dije",2));
        rutinas.add(new RutinaHombre(R.drawable.rutina1,"Rutina 3","Estubiste en clases ",3));
        rutinas.add(new RutinaHombre(R.drawable.rutina1,"Rutina 4","Pudiste correr el dia de ayer",4));

        RutinaHombreListViewAdapter adapter1 = new RutinaHombreListViewAdapter(getApplicationContext(),rutinas);

        lstSF.setAdapter(adapter1);


    }





    public void OnListItemEvents(){
        lstSF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),VideoRutinaHombre.class);

                //Enviamos la información con un putextra
                String titulo = ((RutinaHombre)parent.getItemAtPosition(position)).getTitulo();
                i.putExtra("titulo",titulo);

                String Descripcion = ((RutinaHombre)parent.getItemAtPosition(position)).getDescripcion();
                i.putExtra("descripcion",Descripcion);


                int idvideo = ((RutinaHombre)parent.getItemAtPosition(position)).getIdeVideo();
                i.putExtra("video",idvideo);



                Toast.makeText(getApplicationContext(),"Selecciono: " + idvideo,Toast.LENGTH_LONG).show();
                startActivity(i);

            }
        });
    }




}