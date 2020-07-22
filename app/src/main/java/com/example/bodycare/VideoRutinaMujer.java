package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoRutinaMujer extends AppCompatActivity {
    VideoView videoview;
    TextView titulo, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_rutina_mujer);
        this.InicializarControles();

        this.mostrarVideo();
    }




    private void InicializarControles(){
        videoview = (VideoView)findViewById(R.id.lblVideo);
        titulo = (TextView)findViewById(R.id.lblTitulo);
        descripcion = (TextView)findViewById(R.id.lblDescripcion);
    }

    //Intent i = getIntent();
    //String TituloRutina = i.getStringExtra("Titulo");

    private void mostrarVideo(){




        Intent i = getIntent();
        String nombre = i.getStringExtra("titulo");

        System.out.println("El nombre va aqui debajo");
        System.out.println(nombre);

        String control = "Rutina 1";

        if(control.equals(nombre)){

            videoview.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.p1));
        }


        //videoview.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.p1));
        videoview.setMediaController(new MediaController(this));
        videoview.requestFocus();
        videoview.start();


    }







}