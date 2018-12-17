package com.ejercicio.cardcredits.marcas.response;

public class CardResponse {

    private String nombre;

    private String tasaServicio;

    public CardResponse(String nombre, String tasaServicio) {
        this.nombre = nombre;
        this.tasaServicio = tasaServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTasaServicio() {
        return tasaServicio;
    }

    public void setTasaServicio(String tasaServicio) {
        this.tasaServicio = tasaServicio;
    }
}
