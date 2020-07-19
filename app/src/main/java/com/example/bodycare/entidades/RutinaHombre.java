package com.example.bodycare.entidades;

public class RutinaHombre {

    private int Foto;
    private String Titulo;
    private String Descripcion;
    private int IdeVideo;
    public RutinaHombre(int foto, String titulo, String descripcion, int ideVideo){
        Foto = foto;
        Titulo=titulo;
        Descripcion=descripcion;
        IdeVideo = ideVideo;
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

    public int getIdeVideo() {
        return IdeVideo;
    }

    public void setHora(int ideVideo) {IdeVideo = ideVideo;}

}
