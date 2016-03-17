package blackjack;

import java.util.LinkedList;

public class Hand {

	LinkedList<Card> handOfCards;
	
	Hand(Deck deckOfCards){
		
		//Deal two initial cards from the deck
		this.handOfCards = new LinkedList<Card>();
		handOfCards.add(deckOfCards.deal());
		handOfCards.add(deckOfCards.deal());
		
	}
	
	//Return the number of cards in the hand
	public int takeNewCard(Deck deckOfCards){
		if (this.handOfCards.size() >= 5) {
			return 5;   //5 cards is the max you can have, don't add another
		} else {
		handOfCards.add(deckOfCards.deal());
		return handOfCards.size();
		}
		
	}
	
	public void setBust(){
		//make hand empty. Then score (which iterates over the list) will still work. 
		this.handOfCards.clear();
		
	}
	public int getMinimumScore() {
		
		//Assume ace is low.
		int s = 0;
		
		for (Card c : this.handOfCards) {
			
			int val = c.getMinValue();
			s += val;
		}
		
		return s;
		
	}
	
	public int getScoreClosestTo21(){
		
		//Calculate highest score that doesn't go bust
		//If player has gone bust, return the minimum score

		int maxValid = 0;
		int acesInHand = 0;
		
		//First, be optimistic. Calculate max val assuming ace will be counted as 11
		for (Card c : this.handOfCards){
				maxValid = maxValid + c.getMaxValue();
				if (c.specialTypeOfCard.equals(Card.ACE)) {
					acesInHand++ ;
				}
				
		}

		//Is this max score a valid one? 
		if (maxValid <= 21) {
			return maxValid;
		}
		
		//If hand is over 21, check to see if any aces are present, if so, count them as 1 and check if hand is now valid

		for (int a = acesInHand ; a > 0 ; a--){
			maxValid = maxValid - 10;
			if (maxValid <= 21) {
				return maxValid;
			}
		}
		
		//Still too high? Return maxValid and let Round figure it out
		return maxValid;
		
		
	}
	
	
	public boolean isBust(){
		
		//does hand equal over 21?
		
		int score = this.getMinimumScore();

		if (score > 21) {
			return true;
		}
		return false;
		
	}
	
	
	public String toString(){
		String cards = "";
		for (Card c : handOfCards ) {
			cards = cards + c.toString() + " ";
		}
		return cards;
	}
	
}
