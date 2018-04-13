/*Hieu Ngo
 * 4/10/2018
 * War Card Game implementation 
 * */
import java.util.Scanner;

public class WarCardGame {

	// Class Level Attributes
	// input: Scanner for user input
	static Scanner input = new Scanner(System.in);
	// gameMode: boolean variable to determine the Game Mode (false:simulated || true:playable)
	static boolean gameMode = false;
	/* 
	 * 1) Initialize 6 instances of Deck
	 * 		x2 Player Decks
	 * 		x2 Player War Decks
	 * 		x2 Player Win Decks
	 */
	
	/*******************************************************************************/
	private static Deck Player1Deck = new Deck();
	private static Deck Player2Deck = new Deck();
	private static Deck PlayerWar1Deck = new Deck();
	private static Deck PlayerWar2Deck = new Deck();
	private static Deck PlayerWin1Deck = new Deck();
	private static Deck PlayerWin2Deck = new Deck();

	/*******************************************************************************/
	
	// Main Method
	public static void main(String[] args) {
		String temp1,temp2;
		int tmp1,tmp2;
		// Start the game with a single deck of cards (pre-shuffled)
		Player1Deck.newDeck();
		//Player1Deck.displayDeck();
		
		/* 
		 * 2) Split the deck by removing 26 cards from Player1Deck and adding them to Player2's
		 */
		/*******************************************************************************/
		for(int i=0;i<26;i++)
		{
			Player2Deck.push(Player1Deck.pop());
		}
		/*******************************************************************************/
		
		// Choose whether to play a simulated version or controlled version
		selectMode();
		
		// Play the game until completion or until the user quits
		while (true){
			// If the gameMode is Playable, give the user a turn
			if (gameMode)
				userTurn();
			
			boolean war = true;
			
			while (war)
			{
				/* 
				 * 10) Check if either player has won the game
				 * 11) Check if either players' Deck is empty, if so, then shuffle their Win pile into their Deck
				 * 12) Remove 1 card from either players' Deck, and add it to their respective War pile
				 * 13) Print the top cards from each players' War pile
				 * 14) Compare the top cards from each players' War pile
				 * 14a) If Player1 has a higher card than Player2, remove all cards from the War piles and add them to Player1's Win pile
				 * 14b) If Player2 has a higher card than Player1, remove all cards from the War piles and add them to Player2's Win pile
				 * 14c) If Player1 and Player2 have equal cards, both players remove 3 (or however many are remaining if less) cards and
				 * 			add them to their respective War piles, then repeat step 6
				 */
				/*******************************************************************************/
				checkForWin();
				//10
				if(Player1Deck.isEmpty())
					shuffleWinP1();
				//11
				if(Player2Deck.isEmpty())
					shuffleWinP2();
				//12
				PlayerWar1Deck.push(Player1Deck.pop());
				PlayerWar2Deck.push(Player2Deck.pop());
				//13
				temp1 = (PlayerWar1Deck.peek()).getName();
				temp2 = (PlayerWar2Deck.peek()).getName();
				System.out.println("Player 1 top card is " + temp1);
				System.out.println("Player 2 top card is " + temp2);
				//14
				tmp1 = (PlayerWar1Deck.peek()).getValue();
				tmp2 = (PlayerWar2Deck.peek()).getValue();
				//14a
				if(tmp1 > tmp2)
					winWarP1();
				//14b
				else if(tmp2 > tmp1)
					winWarP2();
				//14c
				else if(tmp1 == tmp2)
				{
					drawWarP1();
					drawWarP2();
				}
				

				/*******************************************************************************/
			}
		}
	}

	// Method to shuffle Player 1's Win pile back into the deck
	private static void shuffleWinP1(){
		System.out.println("Player 1 is out of cards in their deck. Shuffling in their win pile...");
		/* 
		 * 3) Remove all of the cards from Player 1's Win pile and add them to Player 1's Deck
		 * 	  Then, shuffle Player 1's Deck
		 */
		/*******************************************************************************/
		while(!PlayerWin1Deck.isEmpty())
		{
			Player1Deck.push(PlayerWin1Deck.pop());
		}
		Player1Deck.shuffle();
		/*******************************************************************************/
	}
	
	// Method to shuffle Player 2's Win pile back into the deck
	private static void shuffleWinP2(){
		System.out.println("Player 2 is out of cards in their deck. Shuffling in their win pile...");
		/*
		 * 4) Remove all of the cards from Player 2's Win pile and add them to Player 2's Deck
		 * 	  Then, shuffle Player 2's Deck
		 */
	
		/*******************************************************************************/
		while(!PlayerWin2Deck.isEmpty())
		{
			Player2Deck.push(PlayerWin2Deck.pop());
		}
		Player2Deck.shuffle();
		/*******************************************************************************/
	}
	
	// Method to draw 3 cards for War (or however many are remaining if less) for Player 1
	private static void drawWarP1(){
		/* 
		 * 5) Remove 3 cards, or however many are remaining if less, from Player 1's Deck and add them to Player 1's War pile
		 */
		/*******************************************************************************/
		for(int i = 0; i<3;i++)
		{
			if(!Player1Deck.isEmpty())
			{
				PlayerWar1Deck.push(Player1Deck.pop());
			}
		}
		/*******************************************************************************/
	}
	
	// Method to draw 3 cards for War (or however many are remaining if less) for Player 2
	private static void drawWarP2(){
		/* 
		 * 6) Remove 3 cards, or however many are remaining if less, from Player 2's Deck and add them to Player 2's War pile
		 */
		/*******************************************************************************/
		for(int i = 0; i<3;i++)
		{
			if(!Player2Deck.isEmpty())
			{
				PlayerWar2Deck.push(Player2Deck.pop());
			}
		}
		/*******************************************************************************/
	}
	
	// Method to take all of the war cards and place them in Player 1's Win pile
	private static void winWarP1(){
		System.out.println("Player 1 wins the battle!");
		/* 
		 * 7) Remove all of the cards from Player 1's War pile and add them to Player 1's Win pile
		 * 	  Then, remove all of the cards from Player 2's War pile and add them to Player 1's Win pile
		 */
		/*******************************************************************************/
		while(!PlayerWar1Deck.isEmpty())
		{
			Player1Deck.push(PlayerWar1Deck.pop());
		}
		while(!PlayerWar2Deck.isEmpty())
		{
			Player1Deck.push(PlayerWar2Deck.pop());
		}
		/*******************************************************************************/
	}
	
	// Method to take all of the war cards and place them in Player 2's Win pile
	private static void winWarP2(){
		/* 
		 * 8) Remove all of the cards from Player 1's War pile and add them to Player 2's Win pile
		 * 	  Then, remove all of the cards from Player 2's War pile and add them to Player 2's Win pile
		 */
		/*******************************************************************************/
		while(!PlayerWar1Deck.isEmpty())
		{
			Player2Deck.push(PlayerWar1Deck.pop());
		}
		while(!PlayerWar2Deck.isEmpty())
		{
			Player2Deck.push(PlayerWar2Deck.pop());
		}
		/*******************************************************************************/
	}
	
	// Method to check if either player has won the game
	private static void checkForWin(){
		/* 
		 * 9) Check if either player has won the game (The opposite player's Deck and Win pile are empty)
		 * 	  Or if a tie occurs. If a tie occurs, print an end game message and exit.
		 * 	  If a player wins, print a victory message, then exit the game.
		 */
		/*******************************************************************************/
		if(Player1Deck.isEmpty() && Player2Deck.isEmpty() && PlayerWin1Deck.isEmpty()&& PlayerWin2Deck.isEmpty())
		{
			System.out.println("There is a tie!");
			System.out.println("Game ends!");
			System.exit(0);
		}
		else if(Player1Deck.isEmpty() && PlayerWin1Deck.isEmpty())
		{
			System.out.println("Player 2 won the game!");
			System.exit(0);
		}
		else if(Player2Deck.isEmpty() && PlayerWin2Deck.isEmpty() )
		{
			System.out.println("Player 1 won the game!");
			System.exit(0);
		}

		/*******************************************************************************/
	}
	
	// Method to ask the user for the game mode 
	private static void selectMode(){
		System.out.println("Game Modes Available:\n1: Simulated\n2: Playable");
		System.out.print("Enter a Game Mode to play (Invalid inputs will result in Simulated):");
		
		String choice = input.nextLine();
		
		if (choice.equalsIgnoreCase("Playable") || choice.equalsIgnoreCase("2")){
			gameMode = true;
			System.out.println("\nStarting a Playable game...");
			System.out.println("During each turn, press Q to quit or any other key to continue.\n");
			
		} else {
			System.out.println("\nStarting a Simulated game...\n");
		}
	}
	
	// Method to ask the user to continue playing
	private static void userTurn(){
		System.out.print("Player Turn: ");
		
		String choice = input.nextLine();
		
		if (choice.equalsIgnoreCase("Q")){
			System.out.println("Thank you for playing!");
			System.exit(0);
		}
	}
}
