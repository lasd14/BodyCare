package com.example.bodycare.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBBodyCareSQLiteHelper extends SQLiteOpenHelper {
    //query SQL table users


    String sqlCreateRecetas = "CREATE TABLE recetas(imagen TEXT, titulo TEXT, ingredientes TEXT,preparacion TEXT, descripcion TEXT)";

    String sqlCreateComentarios = "CREATE TABLE comentarios(product TEXT, imagen TEXT, client TEXT, score TEXT,type TEXT, descripcion TEXT)";

    //constructor de la clase

    public DBBodyCareSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreateRecetas);
        db.execSQL(sqlCreateComentarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo es mas elaborado, ya que regularmente al eliminar la tabla se debe migrar los datos anteriores



        db.execSQL("DROP TABLE IF EXISTS recetas");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreateRecetas);

        db.execSQL("DROP TABLE IF EXISTS comentarios");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreateComentarios);
    }
}
