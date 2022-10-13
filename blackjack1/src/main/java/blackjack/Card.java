package blackjack;

public class Card {
    private final String suit;
    private final String rank;
    private boolean isFaceDown = true;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(String suit, String rank, boolean isFaceDown) {
        this.suit = suit;
        this.rank = rank;
        this.isFaceDown = isFaceDown;
    }

    public String getColor() {
        if (suit.equalsIgnoreCase("Hearts") || suit.equalsIgnoreCase("Diamonds")) {
            return "Red";
        } else {
            return "Black";
        }
    }

    public void flip() {isFaceDown = !isFaceDown;}

    public String cardString() {
        if (isFaceDown) {
            return "##";
        }
        return rank + " of " + suit + " - " + getColor();
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public boolean isFaceDown() {
        return isFaceDown;
    }

    public void setFaceDown(boolean isFaceDown) {this.isFaceDown = isFaceDown;}
}
