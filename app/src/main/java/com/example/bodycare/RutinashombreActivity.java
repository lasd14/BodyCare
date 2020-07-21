package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


import com.example.bodycare.adaptadores.RutinaHombreListViewAdapter;
import com.example.bodycare.entidades.RutinaHombre;

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
}