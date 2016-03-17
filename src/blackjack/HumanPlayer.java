package blackjack;

import java.util.Scanner;

public class HumanPlayer extends Player {

	HumanPlayer(String name) {
		super(name);
	}
	
	public void playHand(Deck cards) {

		//Display hand
		//hit (take another card) or stand (don't want any more cards)? 

		System.out.println(this.name + " is dealt " + handOfCards + " ( totals " + handOfCards.getScoreClosestTo21() + " )");
	
		boolean morecards = true ;
		boolean bust = false;
		int numberOfCards = 2;
		
		while(morecards== true) {
			System.out.println("hit or stand? h to hit; s to stand");
			Scanner s = new Scanner(System.in);
			String hit = s.next();
			if (hit.equals("h")) {
				//get card
				//bust? 
				numberOfCards = handOfCards.takeNewCard(cards);
				System.out.println(this.name + " now has " + handOfCards + " ( totals " + handOfCards.getScoreClosestTo21()+ " )");
				bust = handOfCards.isBust();
				if (bust) {
					System.out.println(this.name + " went bust ");	
					handOfCards.setBust();
					break;
				}
				if (numberOfCards == 5){
					break;
				}
				
				

			}

			else {
				//Assume anything other than h is stand. Turn done, return. Round can look at the cards and figure out the score. 
				morecards = false;
			}

		}



	}

}
