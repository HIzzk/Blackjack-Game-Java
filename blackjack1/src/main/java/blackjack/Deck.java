package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {

    }

    public Deck(List<Card> cards) {this.cards = new ArrayList<>(cards);}

    public Card draw() {
        if(cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public String deckString() {
        String result = "";

        for (Card c : cards) {
            result += c.cardString() + ", ";
        }
        return result;
    }
}
