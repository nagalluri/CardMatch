package CardMatch;
import CardMatch.Deck;
import CardMatch.Card;
import CardMatch.Hand;

import java.util.Scanner;

/** 
* This is the main file for playing CardMatch
* @author Nag Alluri
*/
public class CardMatch {

	static Hand dealer;
	static Hand player;
	static Deck deck;
	static Hand pot;

	public CardMatch() {
		this.dealer = new Hand();
		this.player = new Hand();
		this.pot = new Hand();
		Deck deck = new Deck();
		deck.shuffle();
		this.deck = deck;
	}

	/**
	* A method to deal card for both players
	*/
	public void deal() {

		for (int i = 0; i < 104; i++) {
			Card c = this.deck.draw();
			if (i < 52) {
				this.dealer.addCardtoHand(c);
			} else {
				this.player.addCardtoHand(c);
			}
		}
	}

	/**
	* A method that adds the pot to player's hand if true, otherwise adds the pot to dealer's hand
	*/
	public void playerTakesPot(boolean win) {
		if (win) {
			System.out.println("MATCH! You take the pot!");
			this.player.addPot(pot);
		} else {
			this.dealer.addPot(pot);
			System.out.println("MATCH! Computer takes the pot!");
		}
	}

	/**
	* A method that places cards into the pot
	*/
	public void play() {
			

		Card c1 = this.player.placeCard();
		System.out.println("You placed: ");
		c1.print();
		
		if (this.pot.cards.size() != 0) {
			Card top = this.pot.cards.get(this.pot.cards.size() - 1);
			// System.out.println("The top card on the pot is: ");
			// top.print();
			if (top.getVal() == c1.getVal()) {
				pot.addCardtoHand(c1);
				playerTakesPot(true);
			}
		}
		pot.addCardtoHand(c1);
		Card c2 = this.dealer.placeCard();
		System.out.println("Computer placed: ");
		c2.print();
		if (c2.getVal() == c1.getVal()) {
			pot.addCardtoHand(c2);
			playerTakesPot(false);
		}
		pot.addCardtoHand(c2);
		System.out.println("---------------------*****--------------------");
		if (this.pot.cards.size() == 0) {
			System.out.println("The pot is currently empty");
		} else {
			Card top = this.pot.cards.get(this.pot.cards.size() - 1);
			System.out.println("The top card on the pot is: ");
			top.print();
		}

		System.out.println("You have " + Integer.toString(this.player.cards.size()) + " cards remaining" );
		System.out.println("Computer has " + Integer.toString(this.dealer.cards.size()) + " cards remaining" );
		System.out.println("The pot has " + Integer.toString(this.pot.cards.size()) + " cards" );
		System.out.println("---------------------*****--------------------");
		

		if (this.player.cards.size() == 0) {
			if (this.dealer.cards.size() == 0) {
				System.out.println("Both players are out of cards! DRAW!");
				System.out.println("Type 'n' to start a new game!");				
			}
			System.out.println("You're out of cards! Computer wins!");
			System.out.println("Type 'n' to start a new game!");
		} else if (this.dealer.cards.size() == 0) {
			System.out.println("Computer is out of cards! YOU WIN!");
			System.out.println("Type 'n' to start a new game!");

		} else {
			System.out.println("Type 'p' to place a card");
		}




		
	}

	/**
	* Main method
	*/
	public static void main(String[] args) {
		System.out.println("Welcome to CardMatch!!!");
		System.out.println("Type 'n' to start a new game!");
		CardMatch m = new CardMatch(); 
		while (true) {
			System.out.print("> ");
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
            String[] rawTokens = line.split(" ");
            String command = rawTokens[0];
            switch (command) {
                case "n":
                	m = new CardMatch();
                	m.deal();
                	System.out.println("Type 'p' to place a card");
                    break;
                case "p":
                	m.play();

                    break;               
                case "Error":
                	System.out.println("Invalid wager");
                	break;
                 case "BettingError":
                	System.out.println("Make a wager to begin (min: 10)");
                	break;
                default:
                    System.out.println("Type 'n' to start a new game!");  
                    break;
            }
		} 
	}
}
		