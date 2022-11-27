/**
 * Implementation of a blackjack player
 */
public class Player {
    /**
     * Player's name
     */
    private String name;

    /**
     * Cards in player's current hand
     */
    private Card[] hand = new Card[10];

    /**
     * number of cards in player's current hand
     */
    private int numCards;
    /**
     * player constructor
     * @Param aName the name of the player
     */
    public Player(String aName) {
        this.name = aName;

        //Set player's hand to empty
        this.emptyHand();
    }
    /**
     * reset player's hand to have no cards
     */
    public void emptyHand() {
        for (int c = 0; c < 10; c++) {
            this.hand[c] = null;
        }
        this.numCards = 0;
    }

    /**
     * Add a card to the player's hand
     * @param aCard the card to add
     * @return whether sum of new hand <= 21
     */
    public boolean addCard(Card aCard) {
        //print error if we have max number of cards
        if (this.numCards == 10) {
            System.err.printf("%s's hand already has 10 cards; " +
                    "cannot add another\n", this.name);
            System.exit(1);
        }
        //Add a new card in next slot and increment number of cards counter
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return (this.getHandSum() <= 21);
    }

    /**
     * Get the sum of cards in the player's hand
     * @return the sum
     */
    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        //calc each card's contribution to the hand sum
        for (int c = 0; c < this.numCards; c++) {
            //get number for current card
            cardNum = this.hand[c].getNumber();

            if (cardNum == 1) { //Ace
                numAces++;
                handSum += 11;
            } else if (cardNum > 10) { //face card
                handSum += 10;
            } else {
                handSum += cardNum;
            }

        }

        //if we have aces but sum >21, set some/all to value 1 instead
        while (handSum > 21 && numAces > 0) {
            handSum-= 10;
            numAces--;
        }

        return handSum;
    }

    /**
     * print cards in player's hand
     * @param showFirstCard whether the first card is hidden or not
     */
    public void printHand(boolean showFirstCard) {
        System.out.printf("%s's cards:\n", this.name);
        for (int c = 0; c < this.numCards; c++) {
            if (c==0 && !showFirstCard) {
                System.out.println("  [Hidden]");
            } else {
                System.out.printf("  %s\n", this.hand[c].toString());
            }

        }
    }

}
