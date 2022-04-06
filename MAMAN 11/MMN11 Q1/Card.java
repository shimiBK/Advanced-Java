import java.util.HashMap;

    /*
    * This class repsresnts a card
     */

public class Card {
    private final String face; // face of card ("Ace", "Deuce", ...)
    private final String suit; // suit of card ("Hearts", "Diamonds", ...)
    private final HashMap<String,Integer> CardValues=  new HashMap<String,Integer>(){{
        put("Ace", 1);
        put("Deuce", 2);
        put("Three", 3);
        put("Four", 4);
        put("Five", 5);
        put("Six", 6);
        put("Seven", 7);
        put("Eight", 8);
        put("Nine", 9);
        put("Ten", 10);
        put("Jack", 11);
        put("Queen", 12);
        put("King", 13);
    }};


   /*
    *two-argument constructor initializes card's face and suit
    * @param cardFace represents the face of card
    * @param carSuit represents the suit of a card
    */
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card


    }
    /*
    *@return String representation of Card
     */
    public String toString() {
        return face + " of " + suit;

    /*
     *@return face of card
    */
}
    public String getFace(){
        return this.face;
    }
    /*
     *@return value of a card
     */

    public int getCardValue(String face)
    {
        return CardValues.get(face);
    }
}