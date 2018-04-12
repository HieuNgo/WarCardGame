public interface DeckInterface {
	// Default Constructor
	// Precondition: None
	// Postcondition: New Deck instance has been initialized
	public void newDeck();
	
	// Method to shuffle the current deck of cards
	// Precondition: None
	// Postcondition: Deck is shuffled.
	public void shuffle();
	
	// Method to print out the current deck of cards
	// Precondition: None
	// Postcondition: All elements in Deck is printed to console
	public void displayDeck();
	
	// Stack Methods
	// Method to add a new card to the top of the deck (push to stack)
	// Precondition: Card must be initialized
	// Postcondition: New element is added to top of Deck
	public void push(Card card);
	
	// Method to draw a card from the top of the deck (pop from stack)
	// Precondition: Deck must not be empty
	// Postcondition: Card on top of deck is removed and returned
	public Card pop();
	
	// Method to determine if the deck is empty
	// Precondition: None
	// Postcondition: Returned boolean value: true if Deck is empty, false is Deck is not empty
	public boolean isEmpty();
	
	// Method to view the card at the top of the deck (peek stack)
	// Precondition: Deck must not be empty
	// Postcondition: Card on top of deck is returned but not removed
	public Card peek();
}
