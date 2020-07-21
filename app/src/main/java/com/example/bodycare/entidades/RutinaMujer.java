package com.example.bodycare.entidades;

public class RutinaMujer {

    private int Foto;
    private String Titulo;
    private String Descripcion;
    private int Idfoto;

    //Ahora creamos el constructor
    public RutinaMujer(int foto, String titulo, String descripcion,  int idfoto){

        Foto = foto;
        Titulo = titulo;
        Descripcion = descripcion;
        Idfoto = idfoto;

    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getIdfoto() {
        return Idfoto;
    }

    public void setIdfoto(int idfoto) {
        Idfoto = idfoto;
    }






}
