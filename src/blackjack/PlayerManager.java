package blackjack;

import java.util.LinkedList;

public class PlayerManager {

	LinkedList<Player> players;
	
	public PlayerManager(LinkedList<Player> players){
		this.players = players;
	}
	
	public boolean allButDealerBust(){
		
		//TODO Dealer doesn't need to bother to play
		
		return false;
	}

	public void printWins() {

		for (Player p : players){
			int wins = p.getWins();
			System.out.println(p.getName() + " won " + wins + " times");
		}
	}

	/* Enable all players to have a chance at being the dealer, in turn */

	public void rotateDealer() {
	
		Player lastDealer = players.removeLast();  //remove last player,
		players.addFirst(lastDealer);              //add them at the beginning.
		
	}

	public void printFinalWins() {

		int mostWins= 0;
		String winnerName = "Computer";
		for (Player p : players){
			int wins = p.getWins();
			System.out.println(p.getName() + " won " + wins + " times");
			if (wins > mostWins) {
				mostWins = wins;
				winnerName = p.getName();
			}
		}
		System.out.println("The winner is " + winnerName);
		
	}
	
	
}
