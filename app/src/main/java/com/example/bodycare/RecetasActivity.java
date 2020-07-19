package com.example.bodycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bodycare.Adaptador.ListViewAdapterRecetas;
import com.example.bodycare.entidades.Recetas;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecetasActivity extends AppCompatActivity {

    ListView lvrecetas;
    ImageView fotoreceta;
    TextView tvnombre, tvdescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        this.InicializarControles();

        //Inicializar controles del bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Inicial
        bottomNavigationView.setSelectedItemId(R.id.recetas);

        //Seleccionador
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.imc:
                        startActivity(new Intent(getApplicationContext(), ImcActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.recetas:
                        return true;

                    case R.id.rutinas:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void InicializarControles(){

        lvrecetas     = (ListView)findViewById(R.id.lvrecetas);
        fotoreceta    = (ImageView)findViewById(R.id.fotoreceta);
        tvnombre      = (TextView)findViewById(R.id.tvnombre);
        tvdescripcion = (TextView)findViewById(R.id.tvdescripcion);

    }

    public void LoadListView(View view){

        List<Recetas> recetasList = new ArrayList<>();

        ListViewAdapterRecetas adapterRecetas = new ListViewAdapterRecetas(getApplicationContext(), recetasList);
        lvrecetas.setAdapter(adapterRecetas);


    }


}