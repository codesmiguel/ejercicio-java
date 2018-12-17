package com.ejercicio.cardcredits.marcas;

import java.time.LocalDate;

public class SQUA implements Card {

    @Override
    public double calcularTasaServicio() {


        LocalDate now = LocalDate.now();

        int year = now.getYear();

        int month = now.getMonthValue();

        return year/month;
    }

    public String datosMarcaTarjeta(){

        return "Marca=" + this.nombre()  + ", tasa="+this.tasaDeServicio();

    }

    @Override
    public String nombre() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String tasaDeServicio() {
        return String.valueOf(this.calcularTasaServicio());
    }

}
