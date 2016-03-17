package blackjack;

public class ComputerPlayer extends Player {

	ComputerPlayer(String name) {
		super(name);
		
	}

	public void playHand(Deck cards){
		
		// TODO this is really similar to playHand in HumanPlayer. Thoughts on abstracting some of this into the Player class? 
		
		System.out.println(this.name + " has " + handOfCards + " ( totals " + handOfCards.getScoreClosestTo21() + " )");
		System.out.println(this.name + " is thinking....");
		
		boolean bust = false;
		int numberOfCards = 2;
		while (this.handOfCards.getScoreClosestTo21() < 17) {
			//take another card
			numberOfCards = this.handOfCards.takeNewCard(cards);
			System.out.println(this.name + " takes another card and now has " + handOfCards + " ( totals " + handOfCards.getScoreClosestTo21() + " )");
			bust = handOfCards.isBust();
			
			if (bust){
				System.out.println(this.name + " goes bust, score = 0");
				handOfCards.setBust();
				break;
			}
			
			if (numberOfCards == 5) {
				break;
			}
		}
		System.out.println(this.name + "'s turn is over");
		
	}
	

}
