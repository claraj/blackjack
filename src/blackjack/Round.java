package blackjack;

import java.util.LinkedList;

public class Round {

	//This class manages one specific round. Deals cards, then gives each player a turn, and decides who won that round
	
	Deck cards;
	
	//ComputerPlayer computerPlayer;
	LinkedList<Player> players;
	
	
	Round(LinkedList<Player> players){
	
		//Create deck
		cards = new Deck();
		
		this.players = players;
		
	}
	
	
	public void play(){
		
		//deal hands to computer and players
	

		for (Player p : this.players){

			Hand hand = new Hand(cards);
			p.setHand(hand);
			
		}
		

		//Abstract class Player insists that all subclasses implement playHand(Deck cards)
		for (Player p : this.players){

			p.playHand(cards);

		}
		
		
		Player winner = determineWinner(players);
		if (winner != null) {
			winner.add1ToWins();
			System.out.println("******************** " + winner.getName() + " wins! ******************** ");
		}
		else {
			System.out.println("******************** Everyone went bust ********************");
		}
		
		
		//If there's no winner, no-one gets more points. 

		
	}


	private Player determineWinner(LinkedList<Player> allPlayers) {

		//TODO have playerManager figure this out
		
		boolean everyoneBust = true;
		
		int maxScore = 0;
	
		Player winner = allPlayers.get(0);  //Assume first player is winner.. unless someone else is
		
		for (Player p : allPlayers) {
			//If there is a tie, the dealer wins
			//The dealer is the LAST players in allPlayers
			//So if we use >= then the dealer's will overwrite the other player
			int playerScore = p.getHandOfCards().getScoreClosestTo21(); 
			
			if (playerScore > 0) {
				//This player did not go bust
				everyoneBust = false;
			}
			
			if (playerScore >= maxScore){
				maxScore = playerScore;
				winner = p;
			}	
			
		}
		
		if (everyoneBust) {
			return null;
		}
		return winner;
		
		
	}



	
	
	
	
}
