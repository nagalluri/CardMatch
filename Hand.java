package CardMatch;
import CardMatch.Deck;
import CardMatch.Card;

import java.util.ArrayList;


/** 
* A class that builds a collection of playing cards
* @author Nag Alluri
*/
public class Hand {

	ArrayList<Card> cards;

	public Hand() {
		this.cards = new ArrayList<Card>();
	}


	/**
	* A method that takes a card and adds it to a Hand
	*/
	public void addCardtoHand(Card c) {
		this.cards.add(c);
	}

	/**
	* A method that draws a card from the top of a players hand
	*/
	public Card placeCard() {
		return this.cards.remove(0);
	}

	/**
	* A method that adds the pot to a player's hand
	*/
	public void addPot(Hand h) {
		ArrayList<Card> newHand = new ArrayList<Card>();
		newHand.addAll(this.cards);
		newHand.addAll(h.cards);
		this.cards = newHand;
		h.cards = new ArrayList<Card>();
		
	}

	/**
	* A method that prints out all of the cards in a hand
	*/
	public void print() {
		for (Card c : this.cards) {
			c.print();
		}
	}



	/**
	* Main method
	*/
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		
		Hand h = new Hand();


	}
}
		