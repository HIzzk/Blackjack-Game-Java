import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * An implementation of a deck of cards
 */

public class Deck {
    /**
     * Array of cards in the deck where top card is first index
     *
     */
//    private ArrayList<Card> myCards;
//    private LinkedList<Card> myCards;
    private Card[] myCards;
    /**
     * Number of cards currently in the deck
     */
    private int numCards;

    /**
     * Constructor with a default of one deck (52 cards) and no shuffling
     */
    public Deck() {
        //Call other constructor, defining one deck without shuffling
        this(1, false);
    }
    /**
     * Constructor that defines the number of decks (i.e. how many sets of 52 cards
     * are in the deck) and whether it should be shuffled
     *
     * @param numDecks number of individual decks in this deck
     * @param shuffle whether to shuffle the cards
     */
    public Deck(int numDecks, boolean shuffle) {
        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];

        int c = 0;
        //Deck
        for (int d = 0; d < numDecks; d++) {
            //Suit
            for (int s = 0; s < 4; s++) {
                //Number
                for (int n = 1; n <= 13; n++) {
                    //Add to deck
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }

        }
        //Shuffle if necessary
        if (shuffle) {
            this.shuffle();
        }
    }

    /**
     * Shuffle deck by randomly swapping pairs of cards
     */
    public void shuffle() {
        //Init random number generator
        Random rng = new Random();

        //temporary card
        Card temp;
        int j;
        for (int i = 0; i < this.numCards; i++) {
            //Get a random card to swap i's value with
            j = rng.nextInt(this.numCards);
            //do swap
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;

        }
    }

    /**
     * Deal next card from top of deck
     * @return dealt card
     */
    public Card dealNextCard() {
        //get top card
        Card top = this.myCards[0];
        //Shift all the subsequent cards to the left
        for (int c = 1; c < this.numCards; c++) {
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards-1] = null;
        //Decrement number of cards
        this.numCards--;
        return top;
    }

    /**
     * print top cards in the deck
     * @param numToPrint number of cards from top of deck to print
     */
    public void printDeck(int numToPrint) {
        for (int c=0; c < numToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
        }
        System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);
    }



}
