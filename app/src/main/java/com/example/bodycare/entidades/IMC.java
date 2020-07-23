package com.example.bodycare.entidades;

public class IMC {

    private String Fecha;
    private String Peso;
    private String IMC;
    private String Estado;

    public IMC(String fecha, String peso, String imc, String estado){
        setFecha(fecha);
        setPeso(peso);
        setIMC(imc);
        setEstado(estado);
    }


    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getIMC() {
        return IMC;
    }

    public void setIMC(String IMC) {
        this.IMC = IMC;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}