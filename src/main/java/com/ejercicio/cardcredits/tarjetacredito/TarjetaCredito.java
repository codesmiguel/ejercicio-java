package com.ejercicio.cardcredits.tarjetacredito;



import com.ejercicio.cardcredits.exception.CobrarException;
import com.ejercicio.cardcredits.marcas.Card;
import com.ejercicio.cardcredits.marcas.CardFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TarjetaCredito {

    private Card marca;

    private String numero;

    private String cardHolder;

    private String fechaVencimiento;



    public boolean operacionValida(double monto){

        return monto < 1000;
    }

    public boolean tarjetaValida(){

        LocalDate today = LocalDate.now();

        LocalDate dateParsed = null;

        YearMonth ym = YearMonth.parse(this.fechaVencimiento, DateTimeFormatter.ofPattern("MM/yy"));

        dateParsed = ym.atEndOfMonth();

        return  today.isBefore(dateParsed);

    }

    public boolean tarjetaDistinta(TarjetaCredito otraTarjetadeCredito){

        return this.getNumero().equals(otraTarjetadeCredito.getNumero());
    }


    public void cobrar() throws CobrarException {

        if(!this.imprimirFactura()){
            throw new CobrarException("La impresora no funciona correctamente");
        }
        if(!this.enviarInfoTC()){
            throw new CobrarException("El host de la tarjeta de credito esta caido");
        }
        if(!this.informarPago()){
            throw new CobrarException("el sistema contable no responde y/o no atiende los pedidos");
        }
        if(!this.actualizarSaldo("Cliente x")){
            throw new CobrarException("La base de datos no permite escribir el nuevo saldo del cliente");
        }

    }

    private boolean imprimirFactura(){
        return true;
    }
    private boolean enviarInfoTC(){
        return false;
    }
    private boolean informarPago(){
        return true;
    }
    private boolean actualizarSaldo(String cliente){
        return false;
    }

    public Card getMarca(){
        return this.marca;
    }

    public void setMarca(Card marca) {
        this.marca = marca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String month,String year) {
        this.fechaVencimiento = month+"/"+year;
    }


    public String getInformacion() {
        return "Tarjeta De Credito{" +
                " numero='" + numero + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }

    public static void main(String[] args) {

        TarjetaCredito tarjetaCredito = new TarjetaCredito();

        CardFactory cardFactory = new CardFactory();

        tarjetaCredito.setMarca(cardFactory.getCard("SQUA"));//creamos una marca cualquiera

        tarjetaCredito.setFechaVencimiento("04","20");

        tarjetaCredito.setNumero("1234561234561234");

        // Invocar un método que devuelva toda la información de una tarjeta
        System.out.println(tarjetaCredito.getInformacion());

        //Informar si una operación es valida
        System.out.println(tarjetaCredito.operacionValida(999));

        //Informar si una tarjeta es válida para operar
        System.out.println(tarjetaCredito.tarjetaValida());

        // Identificar si una tarjeta es distinta a otra
        //creamos nueva tarjeta de credito solo con el numero alcanza para este punto
        TarjetaCredito tarjetaCredito1 = new TarjetaCredito();
        tarjetaCredito1.setNumero("1234561234561234");
        System.out.println(tarjetaCredito.tarjetaDistinta(tarjetaCredito1));


        //Obtener por medio de un método la tasa de una operación informando marca e importe
        System.out.println(tarjetaCredito.getMarca().datosMarcaTarjeta());


    }
}
