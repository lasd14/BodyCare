package com.example.bodycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;


import com.example.bodycare.Helpers.DBBodyCareSQLiteHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ImcActivity extends AppCompatActivity {

    EditText peso,altura,fecha;
    TextView resultado, condicion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        this.InicializarControles();




        //Inicializar controles
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Inicial
        bottomNavigationView.setSelectedItemId(R.id.imc);

        //Seleccionador
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.rutinas:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.imc:
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

    private void InicializarControles(){

        altura = (EditText)findViewById(R.id.etaltura);
        peso = (EditText) findViewById(R.id.etpeso);
        fecha = (EditText)findViewById(R.id.fecha);
        resultado = (TextView) findViewById(R.id.lblresultado);
        condicion = (TextView)findViewById(R.id.lblforma);

    }


    public void CalcularIMC(View view){

        Double pesoC = Double.parseDouble(peso.getText().toString());
        Double alturaC = Double.parseDouble(altura.getText().toString());
        String fechaC = (fecha.getText().toString());
        System.out.println(pesoC);
        System.out.println("CALCULADO");
        System.out.println(alturaC);
        Double alturaT = alturaC/100;
        Double resultadoc = (pesoC/(alturaT*alturaT));
        BigDecimal b1 = new BigDecimal(resultadoc);
        MathContext m = new MathContext(4);
        BigDecimal result = b1.round(m);
        Double calculoIMCE = result.doubleValue();
        String resultadoE="";
        if(calculoIMCE < 18.5 ){
            resultadoE = "Bajo Peso";
        }else if((calculoIMCE>=18.5)&&(calculoIMCE<=24.9)){
            resultadoE = "Normal";
        }else if ((calculoIMCE>=25.0)&&(calculoIMCE<=29.9)){
            resultadoE = "Sobrepeso";
        }else if ((calculoIMCE>=30.0)&&(calculoIMCE<=34.9)){
            resultadoE = "Obesidad grado 1";
        }else if ((calculoIMCE>=35.0)&&(calculoIMCE<=39.9)){
            resultadoE = "Obesidad grado 2";
        }else if (calculoIMCE>=40){
            resultadoE = "Obesidad grado 3";
        }
        resultado.setText(result.toString());
        condicion.setText(resultadoE);

    }


    public void GuardarIMC(View view){

        try {

            String pesoA = peso.getText().toString();
            String fechaD = (fecha.getText().toString());
            String resultA = resultado.getText().toString();
            String estado = condicion.getText().toString();

            //Abrimos la base de datos 'DB' en modo escritura
            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getWritableDatabase();

            //Si hemos abierto correctamente la BD
            if(db !=null){
                //Insertamos 1 receta
                //inseramos en la tabla recipes
                ContentValues newRegistry = new ContentValues();
                newRegistry.put("usuario","Julio");
                newRegistry.put("fecha",fechaD);
                newRegistry.put("peso",pesoA);
                newRegistry.put("imc",resultA);
                newRegistry.put("estado",estado);
                db.insert("masacorporal",null,newRegistry);
                Toast.makeText(getApplicationContext(),"Guardado correctamente",Toast.LENGTH_SHORT).show();
                //Cerramos la BD
                db.close();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }

    }



}