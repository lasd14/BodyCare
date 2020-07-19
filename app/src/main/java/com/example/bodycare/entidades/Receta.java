package com.example.bodycare.entidades;

public class Receta {

    private String Imagen;
    private String Titulo;
    private String Ingredientes;
    private String Preparacion;
    private String Descripcion;



    public Receta( String imagen, String titulo, String ingredientes, String preparacion, String descripcion){
        setImagen(imagen);
        setTitulo(titulo);
        setIngredientes(ingredientes);
        setPreparacion(preparacion);
        setDescripcion(descripcion);
    }

    public String getTitulo() { return Titulo; }

    public void setTitulo(String titulo) { Titulo = titulo; }

    public String getImagen() { return Imagen; }

    public void setImagen(String imagen) { Imagen = imagen; }

    public String getIngredientes() { return Ingredientes; }

    public void setIngredientes(String ingredientes) { Ingredientes = ingredientes; }

    public String getPreparacion() { return Preparacion; }

    public void setPreparacion(String preparacion) { Preparacion = preparacion; }

    public String getDescripcion() { return Descripcion; }

    public void setDescripcion(String descripcion) { Descripcion = descripcion; }
}
