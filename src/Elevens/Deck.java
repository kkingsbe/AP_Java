package Elevens;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<>();

    public Deck(int size)
    {
        Random rng = new Random();
        for(int card = 0; card < size; card ++)
        {
            cards.add(new Card(rng.nextInt(12) + 1));
        }
    }

    public String toString() {
        String cardsStr = "";
        for(Card card : cards)
        {
            cardsStr += " " + card;
        }
        return cardsStr;
    }
}
