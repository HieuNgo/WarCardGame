import java.util.ArrayList;
import java.util.Collections;

public class Deck implements DeckInterface{
	// Class Level Attributes
	// deckOfCards: ArrayList that contains Card objects
	private ArrayList<Card> deckOfCards = new ArrayList<Card>();
	
	// Deck Methods
	// Method to create a new deck of 52 unique Card objects
	public void newDeck(){
		for (int value = 1; value <= 13; value++){
			for (int suit = 1; suit <= 4; suit++){
				String newSuit;
				String newValue;
				switch(value){
				case 11:
					newValue = "Jack";
					break;
				case 12:
					newValue = "Queen";
					break;
				case 13:
					newValue = "King";
					break;
				case 1:
					newValue = "Ace";
					break;
				default:
					newValue = String.valueOf(value);
					break;
				}
				switch(suit){
				case 1:
					newSuit = "Clubs";
					break;
				case 2:
					newSuit = "Diamonds";
					break;
				case 3:
					newSuit = "Hearts";
					break;
				default:
					newSuit = "Spades";
					break;
				}
				deckOfCards.add(new Card(newSuit, newValue));
			}
		}
		// Shuffle the newly formed deck
		shuffle();
	}
	
	// Method to shuffle the current deck of cards
	public void shuffle(){
		Collections.shuffle(deckOfCards);
	}
	
	// Method to print out the current deck of cards
	public void displayDeck(){
		for (Card card : deckOfCards){
			System.out.println(card.getName());
		}
	}
	
	// Stack Methods
	// Method to add a new card to the top of the deck (push to stack)
	public void push(Card card){
		deckOfCards.add(card);
	}
	
	// Method to draw a card from the top of the deck (pop from stack)
	public Card pop(){
		Card card = deckOfCards.get(deckOfCards.size()-1);
		deckOfCards.remove(deckOfCards.size()-1);
		return card;
	}
	
	// Method to determine if the deck is empty
	public boolean isEmpty(){
		return deckOfCards.isEmpty();
	}
	
	// Method to view the card at the top of the deck (peek stack)
	public Card peek(){
		Card card = deckOfCards.get(deckOfCards.size()-1);
		return card;
	}
}
