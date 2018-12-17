package com.ejercicio.cardcredits.marcas;

public class CardFactory {

    public Card getCard(String cardType){

        if(cardType == null){

            return null;

        }

        if(cardType.equalsIgnoreCase("SQUA")){

            return new SQUA();

        } else if(cardType.equalsIgnoreCase("SCO")){

            return new SCO();

        } else if(cardType.equalsIgnoreCase("PERE")){

            return new PERE();

        }

        return null;

    }

}
