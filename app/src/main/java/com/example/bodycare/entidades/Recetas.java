package com.example.bodycare.entidades;

public class Recetas {

    private String nombre;
    private String descripcion;
    private int foto;

    //Dependiendo de si utilizamos picasso o algo se cambia el tipo de variable para la foto
    //Actualmente esta int por ser un imageResource

    public Recetas(String nom, String descrip, int ft) {

        nombre      = nom;
        descripcion = descrip;
        foto        = ft;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }



}
