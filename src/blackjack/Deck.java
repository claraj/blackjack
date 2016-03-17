package blackjack;

import java.util.LinkedList;
import java.util.Random;

public class Deck {

	private final String suits[] = {"H", "C", "S", "D"};
	private LinkedList<Card> cards;

	public Deck() {

		this.cards = new LinkedList<Card>();

		for (int s = 0 ; s < 4 ; s++){

			for (int v = 1 ; v <= 13 ; v++){
				if (v == 1) {
					Card c = new Card(v, suits[s], Card.ACE);
					cards.add(c);
				}
				else if (v > 1 && v <= 10) {
					Card c = new Card(v, suits[s], Card.NOT_FACE_NOT_ACE);
					cards.add(c);
				} else if (v == 11) {
					Card c = new Card(10, suits[s], Card.JACK);
					cards.add(c);	
				} else if (v == 12) {
					Card c = new Card(10, suits[s], Card.QUEEN);
					cards.add(c);	
				} else if (v == 13) {
					Card c = new Card(10, suits[s], Card.KING);
					cards.add(c);	
				}


			}
		}

	}

	public Card deal(){

		//generate random number in range 
		int cardsLeft = this.cards.size();
		Random rng = new Random();
		int cardpick = rng.nextInt(cardsLeft);
		return cards.remove(cardpick);   //delete this card so it is not drawn again

	}


}
