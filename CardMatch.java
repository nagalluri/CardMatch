package CardMatch;
import CardMatch.Deck;
import CardMatch.Card;
import CardMatch.Hand;

import java.util.Scanner;

/** 
* Input file description here.
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
		Deck deck = new Deck();
		deck.shuffle();
		this.deck = deck;
	}

	/**
	* A method to deal card for both players
	*/
	public void deal() {

		for (int i = 0; i <= 52; i++) {
			Card c = this.deck.draw();
			if (i < 26) {
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
			this.player.addPot(pot);
		} else {
			this.dealer.addPot(pot);
		}
	}

	/**
	* Main method
	*/
	public static void main(String[] args) {

	}
}
		