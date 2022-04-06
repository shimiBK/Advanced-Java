import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
    // random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
    private ArrayList<Card> deck = new ArrayList<>(); // Card references

/*
*Initializes a new deck of cards
 */
    public DeckOfCards() {

        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
// populate deck with Card objects
        for (int count = 0; count < NUMBER_OF_CARDS; count++) {

            deck.add(count,new Card(faces[count % 13], suits[count / 13]));
        }
    }
/*
* Shuffles the cards randomly
 */

    public void shuffle() {
// for each Card, pick another random Card (0-51) and swap them
        for (int first = 0; first < deck.size(); first++) {
// select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card
            Card temp = deck.get(first);
            deck.set(first,deck.get(second));
            deck.set(second, temp);
        }
    }

/*
* Deals One card
* @return the dealt card if there are cards left else returns null
 */
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (!(deck.isEmpty())) {
            Card myCard = deck.get(0);
            deck.remove(0);
            return myCard; // return current Card in array

        } else {
            return null; // return null to indicate that all Cards were dealt
        }
    }

}



