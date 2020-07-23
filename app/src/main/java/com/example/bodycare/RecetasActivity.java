package com.example.bodycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodycare.Helpers.DBBodyCareSQLiteHelper;
import com.example.bodycare.adaptadores.RecetasListViewAdapter;
import com.example.bodycare.entidades.Receta;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class RecetasActivity extends AppCompatActivity {

    ListView listView;
    Button delete, refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        this.InicializarControles();
        this.LoadList();
        this.OnListItemEvents();
        this.GetData();

        //Inicializar controles
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
        listView = (ListView)findViewById(R.id.lstSF);
        delete   = (Button)findViewById(R.id.delete);
        refresh  = (Button)findViewById(R.id.refresh);
    }
    public void AgregarReceta(View view){
        Intent i = new Intent(getApplicationContext(),GuardarRecetaActivity.class);
        startActivity(i);

    }
    public void OnListItemEvents(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inte = new Intent(getApplicationContext(), RecetaActivity.class);
                //Enviamos el producto seleccionado
                String productoSeleccionado = ((Receta)parent.getItemAtPosition(position)).getTitulo();
                inte.putExtra("titulo", productoSeleccionado);
                //Enviamos la descripcion seleccionada
                String descripcionProduco = ((Receta)parent.getItemAtPosition(position)).getDescripcion();
                inte.putExtra("descri",descripcionProduco);
                //Enviamos la imagen seleccionada
                String imagenProduco = ((Receta)parent.getItemAtPosition(position)).getImagen();
                inte.putExtra("imagen",imagenProduco);

                Toast.makeText(getApplicationContext(),"Selecciono: " + productoSeleccionado,Toast.LENGTH_LONG).show();
                startActivity(inte);

            }
        });

    }

    private void LoadList(){

        try {
            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getReadableDatabase();
            List<Receta> recetas = new ArrayList<>();
            String[] campos = new String[]{"imagen","titulo","ingredientes","preparacion","descripcion"};
            Cursor cursor = db.query("recetas", campos, null, null, null, null
                    , null);
            if (cursor.moveToFirst()){
                do {
                    Receta receta = new Receta(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)
                    );
                    recetas.add(receta);


                }while (cursor.moveToNext());
            }


            RecetasListViewAdapter adapter = new RecetasListViewAdapter(getApplicationContext(), recetas);
            listView.setAdapter(adapter);


        }catch (Exception e){
            Toast.makeText(this,"Error -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

    }
    public void Recargar(View view){
        this.LoadList();
    }

    private void GetData(){
        SharedPreferences prefs = getSharedPreferences("user", Context.MODE_PRIVATE);
        String type = prefs.getString("type", "");
        if(type.equals("admin")){
            delete.setVisibility(View.VISIBLE);
            refresh.setVisibility(View.VISIBLE);
        }
//        if(type.equals("client")){
//            save.setVisibility(View.VISIBLE);
//            puntuacion.setVisibility(View.VISIBLE);
//            comentario.setVisibility(View.VISIBLE);
//
//
//        }
    }

}