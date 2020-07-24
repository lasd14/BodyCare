package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodycare.Helpers.DBBodyCareSQLiteHelper;
import com.squareup.picasso.Picasso;

public class RecetaActivity extends AppCompatActivity {
    ImageView imagen;
    TextView titulo, ingredientes, preparacion, descripcion;
    Button urlboton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);
        this.InicializarControles();
        this.LoadReceta();
    }
    private void InicializarControles(){
        imagen = (ImageView)findViewById(R.id.imgImagen);
        titulo = (TextView)findViewById(R.id.lblTitulo);
        ingredientes = (TextView)findViewById(R.id.lblIngredientes);
        preparacion = (TextView)findViewById(R.id.lblPreparacion);
        descripcion = (TextView)findViewById(R.id.lblDescripcion);
        urlboton    = (Button)findViewById(R.id.urlboton);

        urlboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.barufresh.com/"));
                startActivity(url);
            }
        });

    }



    private void LoadReceta(){
        try {
            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getReadableDatabase();

            if (db !=null){
                String[] campos = new String[]{"imagen","titulo","ingredientes","preparacion","descripcion"};

                Intent i = getIntent();
                String nombre = i.getStringExtra("titulo");
                String[] args = new String[]{nombre};
                Cursor cursor = db.query("recetas", campos, "titulo = ?", args, null, null
                        , null);
                if (cursor.moveToFirst()){
                    do {
                        Picasso.get().load(cursor.getString(0)).into(imagen);
                        titulo.setText(cursor.getString(1));
                        ingredientes.setText(cursor.getString(2));
                        preparacion.setText(cursor.getString(3));
                        descripcion.setText(cursor.getString(4));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"Error -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }
}