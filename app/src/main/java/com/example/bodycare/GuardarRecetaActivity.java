package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodycare.Helpers.DBBodyCareSQLiteHelper;

public class GuardarRecetaActivity extends AppCompatActivity {

    EditText img, titulo , ingredientes, preparacion, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_receta);
        this.InicializarControles();
    }

    private void InicializarControles(){
        img = (EditText)findViewById(R.id.edtImg);
        titulo = (EditText)findViewById(R.id.edtTitulo);
        ingredientes = (EditText)findViewById(R.id.edtIngredientes);
        preparacion = (EditText)findViewById(R.id.edtPreparacion);
        descripcion = (EditText)findViewById(R.id.edtDescripcion);

    }
    public void GuardarReceta(View view){

        try {
            String imagenR = img.getText().toString();
            String tituloR = titulo.getText().toString();
            String ingredientesR = ingredientes.getText().toString();
            String preparationR = preparacion.getText().toString();
            String descripcionR = descripcion.getText().toString();

            //Abrimos la base de datos 'DB' en modo escritura
            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getWritableDatabase();

            //Si hemos abierto correctamente la BD
            if(db !=null){
                //Insertamos 1 receta
                //inseramos en la tabla recipes

                ContentValues newRegistry = new ContentValues();
                newRegistry.put("imagen",imagenR);
                newRegistry.put("titulo",tituloR);
                newRegistry.put("ingredientes",ingredientesR);
                newRegistry.put("preparacion",preparationR);
                newRegistry.put("descripcion",descripcionR);
                db.insert("recetas",null,newRegistry);

                Intent guardado = new Intent(getApplicationContext(), RecetasActivity.class);
                startActivity(guardado);
                Toast.makeText(getApplicationContext(),"Guardado correctamente",Toast.LENGTH_SHORT).show();


                //Cerramos la BD

                db.close();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }

    }
}