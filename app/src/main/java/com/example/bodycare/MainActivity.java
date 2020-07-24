package com.example.bodycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar controles
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Inicial
        bottomNavigationView.setSelectedItemId(R.id.rutinas);

        //Seleccionador
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.imc:
                        startActivity(new Intent(getApplicationContext(), ImcActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.rutinas:
                        return true;

                    case R.id.recetas:
                        startActivity(new Intent(getApplicationContext(), RecetasActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mapa:
                Intent mapa = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(mapa);
                return true;
            case R.id.logout:
                Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(logout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public  void verRuinasHombres(View view){

        Intent i = new Intent(getApplicationContext(),RutinashombreActivity.class);
        startActivity(i);


    }

    public  void verRuinasMujeress(View view){
        Intent i = new Intent(getApplicationContext(),RutinamujerActivity.class);
        startActivity(i);


    }
}