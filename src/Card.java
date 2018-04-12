public class Card {
	// Class Level Attributes
	// value: int value of the card (Aces high)
	// name : String representation of the name of the card
	private int value = 0;
	private String name = "";
	
	// Constructors
	// Dummy constructor to prevent uninitialized values
	private Card(){}
	
	// Public constructor
	// Inputs: aSuit - String value of the suit
	//		 : aValue - String value of the value (converted to int)
	public Card(String aSuit, String aValue){
		name = aValue + " of " + aSuit;
		switch(aValue){
		case "Ace":
			value = 14;
			break;
		case "Jack":
			value = 11;
			break;
		case "Queen":
			value = 12;
			break;
		case "King":
			value = 13;
			break;
		default:
			try{
				value = Integer.parseInt(aValue);
			} catch (Exception e){
				System.out.println("Critical Error: Unable to parse the card value. Exiting game...");
				System.exit(-1);
			}	
		}
	}
	
	// Get Methods
	// Public method to get the card name
	public String getName(){
		return name;
	}
	
	// Public method to get the card value
	public int getValue(){
		return value;
	}
}
