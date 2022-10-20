package blackjack;

import java.util.Scanner;

public class UserInterface {

    Scanner myScanner = new Scanner(System.in);
    Deck theDeck = new Deck();

    public void makeFirstDeck() {
        makeDeck(theDeck);
    }

    public void welcomeMenu() {
        while (true) {
            System.out.println("Welcome to the BlackJack App!");
            System.out.println("Would you like to play?");
            System.out.println();
            System.out.println("1) Play new game");
            System.out.println("2) Quit");
            String userChoice = myScanner.nextLine();
            try {
                int userInt = Integer.parseInt(userChoice);
                switch (userInt) {
                    case 1:
                        setupGame();
                        break;
                    case 2:
                        System.exit(0);
                }

            } catch (NumberFormatException e) {

            }
        }
    }

    public void setupGame() {
        while (true) {
            System.out.println("New Game");
            System.out.println();
            System.out.println("Set initial cash");
            System.out.println("Set bet amount");
            System.out.println("Return to main menu");
        }
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
