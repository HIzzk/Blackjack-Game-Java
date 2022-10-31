package blackjack;

import java.util.Scanner;

public class UserInterface {

    Scanner myScanner = new Scanner(System.in);
    Deck theDeck = new Deck();
    Money userMoney = new Money();

//    public void makeFirstDeck() {
//        makeDeck();
//    }

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
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    boolean setup = true;
    public void setupGame() {

        while (setup) {
            System.out.println("New Game");
            System.out.println();
            System.out.println("1) Set initial cash");
            System.out.println("0) Return to main menu");
            String userChoice = myScanner.nextLine();
            try {
                int userInt = Integer.parseInt(userChoice);

                switch (userInt) {
                    case 1:
                        Deck firstDeck = makeDeck();
                        System.out.println("Enter quantity: ");
                        String userMoneyString = myScanner.nextLine();
                        double userMoneyDouble = 0;
                        try {
                            userMoneyDouble = Double.parseDouble(userMoneyString);
                            if (userMoneyDouble < 0) {
                                throw new NumberFormatException();
                            }
                            userMoney.setMoney(userMoneyDouble);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a positive quantity");
                        }
                        break;
                    case 0:
                        setup = false;
                        break;
                }
                System.out.println("1) Set bet amount");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public Deck makeDeck() {
        Deck newDeck = new Deck();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for(String rank : ranks) {
                Card newCard = new Card(suit, rank);
                newDeck.addCard(newCard);
            }
        }
        return newDeck;
    }
}
