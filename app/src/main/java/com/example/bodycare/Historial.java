package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bodycare.Helpers.DBBodyCareSQLiteHelper;
import com.example.bodycare.adaptadores.HistorialListViewAdapter;

import com.example.bodycare.entidades.IMC;


import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        this.InicializarControles();
        this.LoadList();
    }

    private void InicializarControles(){
        listView = (ListView)findViewById(R.id.lstSFH);
    }
    private void LoadList(){

        try {
            SharedPreferences prefs = getSharedPreferences("user", Context.MODE_PRIVATE);
            String usuario = prefs.getString("name", "");

            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getReadableDatabase();
            List<IMC> imcs = new ArrayList<>();

            String[] campos = new String[]{"fecha","peso","imc","estado"};
            String[] args = new String[]{usuario};
            Cursor cursor = db.query("imc", campos, "usuario = ?", args, null, null
                    , null);
            if (cursor.moveToFirst()){
                do {
                    IMC imc = new IMC(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3)

                    );
                    imcs.add(imc);


                }while (cursor.moveToNext());
            }


            HistorialListViewAdapter adapter = new HistorialListViewAdapter(getApplicationContext(), imcs);
            listView.setAdapter(adapter);


        }catch (Exception e){
            Toast.makeText(this,"Error -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

    }
}