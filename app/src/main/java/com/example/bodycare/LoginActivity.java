package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bodycare.Helpers.DBBodyCareSQLiteHelper;

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;

    String userR, passR, typeR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.InitializeControls();
        this.SaveUsers();
    }

    private void InitializeControls(){
        user = (EditText)findViewById(R.id.edtUser);
        pass = (EditText)findViewById(R.id.edtPass);
    }

    private  void SaveUsers(){

        try{

            //Abrimos la base de datos 'DBBodyCare' en modo escritura
            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getWritableDatabase();

            //Si hemos abierto correctamente la BD
            if(db !=null){
                //Insertamos 1 usuario
                //inseramos en la tabla users


                db.execSQL("INSERT INTO usuarios(usuario,contrasena,tipo)"+
                        "VALUES ('Julio','12345','client')");

                db.execSQL("INSERT INTO usuarios(usuario,contrasena,tipo)"+
                        "VALUES ('Diego','54321','admin')");

                //Cerramos la BD

                db.close();
            }

        }catch (Exception e){
            Toast.makeText(this,"Error -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();

        }

    }

    //Este metodo nos ayudara a saber que usuario se encuentra logueado
    private void SharedPreferences(String file,String name, String type){
        SharedPreferences prefs = getSharedPreferences(file, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("name",name);
        editor.putString("type",type);

        editor.commit();

    }

    public void Login(View view){
        String userLogin = user.getText().toString();
        String passLogin = pass.getText().toString();

        try {
            DBBodyCareSQLiteHelper dbBodyCareSQLiteHelper = new DBBodyCareSQLiteHelper(this,"DBBodyCare",null,1);
            SQLiteDatabase db = dbBodyCareSQLiteHelper.getReadableDatabase();

            if (db !=null){

                String[] campos = new String[]{"usuario","contrasena","tipo"};
                String[] args = new String[]{userLogin,passLogin};
                Cursor cursor = db.query("usuarios", campos, "usuario = ? and contrasena = ?", args, null, null
                        , null);

                if (cursor.moveToFirst()){
                    do {

                        userR = cursor.getString(0);
                        passR = cursor.getString(1);
                        typeR = cursor.getString(2);

                    }while (cursor.moveToNext());
                }

                if (userLogin.equals(userR) && passLogin.equals(passR)){

                    SharedPreferences("user",userR,typeR);

                    Toast.makeText(this,"REGISTRADO",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(),MainActivity.class);

                    startActivity(i);

                }else{
                    Toast.makeText(this,"NO ESTAS REGISTRADO",Toast.LENGTH_LONG).show();
                }
            }

        }catch (Exception e){
            Toast.makeText(this,"Error -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

    }
}