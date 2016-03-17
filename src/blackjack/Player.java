package blackjack;


public abstract class Player {

	int wins = 0;
	String name;
	Hand handOfCards;

	Player(String name){
		this.name=name;
	}

	//Insist that subclasses implement this method.
	public abstract void playHand(Deck allCards);
	
	public void add1ToWins(){
		wins++;
	}
	
	public String getName() {
		return name;
	}


	public Hand getHandOfCards() {
		return handOfCards;
	}


	public void setHand(Hand handOfCards) {
		this.handOfCards = handOfCards;
	}

	public int getWins() {
		return wins;
	}

}
