package com.ejercicio.cardcredits.marcas;

import java.time.LocalDate;

public class PERE implements Card {



    @Override
    public double calcularTasaServicio() {

        LocalDate now = LocalDate.now();

        int month = now.getMonthValue();

        return month * 0.1;

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
