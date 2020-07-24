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
        rutinas.add(new RutinaHombre(R.drawable.rutina1h, "Rutina 1","Para trabajar con la rueda abdominal comienza por hacer series de pocas repeticiones, como por ejemplo, 4 series de 5 a 7 repeticiones y ve avanzando. La dificultad aumenta conforme se realiza el ejercicio más lento. Para trabajar más los abdominales oblícuos puedes dirigir la rueda abdominal hacia los lados.",1));
        rutinas.add(new RutinaHombre(R.drawable.rutina2h,"Rutina 2","El entrenamiento de intervalos de alta intensidad, es un entrenamiento de fuerza-resistencia, ya que combina ejercicios anaeróbicos y aeróbicos. Habitualmente las sesiones HIIT pueden variar de entre 4 y 30 minutos.",2));
        rutinas.add(new RutinaHombre(R.drawable.rutina3h,"Rutina 3","Los ejercicios aeróbicos incluyen cualquier tipo de ejercicio que se practique a niveles moderados de intensidad durante períodos de tiempos extensos, lo que hace mantener una frecuencia cardíaca más elevada.",3));
        rutinas.add(new RutinaHombre(R.drawable.rutina4h,"Rutina 4","Hacer sentadillas es un movimiento fundamental muy útil en todas las disciplinas deportivas y un ejercicio básico de fortalecimiento muscular. El principio consiste en ponerse de pie, con las piernas separadas a la altura de los hombros, los pies hacia fuera y la mirada hacia lo lejos.",4));

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