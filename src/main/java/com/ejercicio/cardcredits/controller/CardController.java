package com.ejercicio.cardcredits.controller;


import com.ejercicio.cardcredits.marcas.Card;
import com.ejercicio.cardcredits.marcas.CardFactory;
import com.ejercicio.cardcredits.marcas.response.CardResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardController {

    @RequestMapping("/cards")
    public List<CardResponse> cards(){

        String [] cardsAvailable = {"SQUA","SCO","PERE"};

        List<CardResponse> cards = new ArrayList<>();

        CardFactory cardFactory = new CardFactory();

        for (String newCard:cardsAvailable) {

            Card card = cardFactory.getCard(newCard);
            CardResponse cardResponse = new CardResponse(card.nombre(),card.tasaDeServicio());
            cards.add(cardResponse);

        }

        return cards;
    }
}
