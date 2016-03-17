package blackjack;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		/* TODO list

		Getting 5 cards beats other hands of the same value
		
		Add functionality to add as many players as needed, ask for names.
		You may wish to delegate this to the PlayerManager class.

		Players should be aware of other player's hands.

		Last player should not bother taking another card if everyone else
		is bust since they will win by default

		If a computer has over 17, it won't take another card. Maybe if computer has
		(e.g.) 18 and other player haves 20, should still take card just in case.   */

		
		ComputerPlayer pc = new ComputerPlayer("Mac");
		HumanPlayer human = new HumanPlayer("Clara");
		HumanPlayer human2 = new HumanPlayer("Andy");
		ComputerPlayer pc2 = new ComputerPlayer("Linux");
		//Can modify this to add more human players and computer players if needed
		
		
		LinkedList<Player> allPlayers = new LinkedList<Player>();
		allPlayers.add(pc);
		//allPlayers.add(human);    //If you want to play too, uncomment this line
		//allPlayers.add(human2);
		allPlayers.add(pc2);
		PlayerManager playerManager = new PlayerManager(allPlayers);

		
		boolean playAgain = true;
		String anotherRound;
		Scanner scanner = new Scanner(System.in);
		
		while (playAgain){
			
			Round r = new Round(allPlayers);
			r.play();
			playerManager.printWins();
			
			System.out.println("Another hand? n to quit, anything else to continue... ");
			anotherRound = scanner.next();

			playAgain = !anotherRound.equals("n");   // another.equals("n") returns a boolean
			
			//rotate the dealer, so everyone gets turns to be the dealer.
			//The last player in the array is the dealer.
			playerManager.rotateDealer();
			
		}
		
		playerManager.printFinalWins();
		
		scanner.close();

	}
	


}
