package com.example.bodycare.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBBodyCareSQLiteHelper extends SQLiteOpenHelper {
    //query SQL table users


    String sqlCreateRecetas = "CREATE TABLE recetas(imagen TEXT, titulo TEXT, ingredientes TEXT,preparacion TEXT, descripcion TEXT)";

    String sqlCreateComentarios = "CREATE TABLE comentarios(product TEXT, imagen TEXT, client TEXT, score TEXT,type TEXT, descripcion TEXT)";

    String sqlCreateIMC = "CREATE TABLE imc(usuario TEXT, fecha TEXT, peso TEXT, imc TEXT, estado TEXT)";

    String sqlCreateUsers = "CREATE TABLE usuarios(usuario TEXT, contrasena TEXT, tipo TEXT)";

    //constructor de la clase

    public DBBodyCareSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreateRecetas);
        db.execSQL(sqlCreateComentarios);
        db.execSQL(sqlCreateIMC);
        db.execSQL(sqlCreateUsers);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo es mas elaborado, ya que regularmente al eliminar la tabla se debe migrar los datos anteriores



        db.execSQL("DROP TABLE IF EXISTS recetas");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreateRecetas);

        db.execSQL("DROP TABLE IF EXISTS usuarios");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreateUsers);


        db.execSQL("DROP TABLE IF EXISTS imc");
        db.execSQL(sqlCreateIMC);

        db.execSQL("DROP TABLE IF EXISTS comentarios");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreateComentarios);
    }
}