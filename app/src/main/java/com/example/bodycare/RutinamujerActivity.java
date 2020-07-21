package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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


    }


    public void LoasList(){

        List<RutinaMujer> rutinas = new ArrayList<>();

        rutinas.add(new RutinaMujer(R.drawable.rutina1, "Rutina 1", "Esta rutina trata de llevar a un fisico mejor", 1));
        rutinas.add(new RutinaMujer(R.drawable.rutina1, "Rutina 2", "Esta rutina trata de llevar a un fisico mejor", 2));
        rutinas.add(new RutinaMujer(R.drawable.rutina1, "Rutina 3", "Esta rutina trata de llevar a un fisico mejor", 3));
        rutinas.add(new RutinaMujer(R.drawable.rutina1, "Rutina 4", "Esta rutina trata de llevar a un fisico mejor", 4));

        RutinaMujerListViewAdapter adapter = new RutinaMujerListViewAdapter(getApplicationContext(),rutinas);

        lstSf.setAdapter(adapter);

    }
}