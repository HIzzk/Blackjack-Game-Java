package blackjack;

public class UserInterface {

    Deck theDeck = new Deck();

    public void makeFirstDeck() {
        makeDeck(theDeck);
    }


    public void makeDeck(Deck testDeck) {
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for(String rank : ranks) {
                Card newCard = new Card(suit, rank);
                testDeck.addCard(newCard);
            }
        }
    }

}
