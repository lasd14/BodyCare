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
        this.LoadList();

        lstSF = (ListView)findViewById(R.id.lstSF);
    }





    private void LoadList(){

        List<RutinaHombre> rutina = new ArrayList<>();
        rutina.add(new RutinaHombre(R.drawable.rutina1, "Rutina 1","Como quedo la tarea",1));
        rutina.add(new RutinaHombre(R.drawable.rutina1,"Rutina 2","Te llego el mensaje que te dije",2));
        rutina.add(new RutinaHombre(R.drawable.rutina1,"Rutina 3","Estubiste en clases ",3));
        rutina.add(new RutinaHombre(R.drawable.rutina1,"Rutina 4","Pudiste correr el dia de ayer",4));

        RutinaHombreListViewAdapter adapter = new RutinaHombreListViewAdapter(getApplicationContext(),rutina);

        lstSF.setAdapter(adapter);


    }
}