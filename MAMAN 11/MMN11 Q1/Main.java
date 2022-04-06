
import javax.swing.*;
import java.util.ArrayList;

/**
 * Maman 11 Question 1
 * @author Shimi Ben Kalifa
 * @version 2022b
 */

public class Main {
    // execute application
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

    public static void main(String[] args) {

        warGame();

}

public static void warGame()
{
    DeckOfCards myDeckOfCards = new DeckOfCards();
    ArrayList<Card> warCards = new ArrayList<>();

    ArrayList<Card> playerOneDeck = new ArrayList<>();
    ArrayList<Card> playerTwoDeck = new ArrayList<>();
    String outPutMessage;


    myDeckOfCards.shuffle(); // place Cards in random order

    //Divide 26 Cards for each player
    divideDeck(playerOneDeck,playerTwoDeck ,myDeckOfCards);

    //Game Starts

    while(!(playerOneDeck.isEmpty()) && !(playerTwoDeck.isEmpty()))
    {

        Card playerOneCard = playerOneDeck.remove(0); // get player's one card
        Card playerTwoCard = playerTwoDeck.remove(0); // get player's two card


        outPutMessage = "Player One Card is: " + playerOneCard + "\nPlayer Two Card is: " + playerTwoCard.toString();
        JOptionPane.showMessageDialog(null , outPutMessage);

        // Player One Wins
        if(playerOneCard.getCardValue(playerOneCard.getFace()) > playerTwoCard.getCardValue(playerTwoCard.getFace()))
        {
            outPutMessage = "\nPlayer One Wins the Round";
            JOptionPane.showMessageDialog(null , outPutMessage);
            // add cards to player's one deck
            addCardsToDeck(playerOneDeck,playerOneCard,playerTwoCard,warCards);

        }
        //Player Two Wins
        else if(playerOneCard.getCardValue(playerOneCard.getFace()) < playerTwoCard.getCardValue(playerTwoCard.getFace()))
        {
            outPutMessage = "\nPlayer Two Wins the Round";
            JOptionPane.showMessageDialog(null , outPutMessage);
            // add both cards to player's two deck
            addCardsToDeck(playerTwoDeck,playerOneCard,playerTwoCard,warCards);

        }
        // War Begins
        else {
            outPutMessage = "Tie! , Its a war";
            JOptionPane.showMessageDialog(null , outPutMessage);

            warCards.add(playerOneCard);
            warCards.add(playerTwoCard);

            for(int i = 0; i < 2; i++)
            {
                // Check if one of players is out of cards
                if(playerOneDeck.size() == 0 || playerTwoDeck.size() == 0)
                    break;

                playerOneCard = playerOneDeck.remove(0); // get player's war cards
                playerTwoCard = playerTwoDeck.remove(0); // get player's war cards
                warCards.add(playerOneCard);
                warCards.add(playerTwoCard);
            }

        }
    }

    declareWinner(playerOneDeck,playerTwoDeck); // Announce The Winner of the

}

    /*
     * Divides a deck into 2 half's
     * @param pOneDeck is player's one deck
     * @param pTwoDeck is player's two deck
     * @param deckOfCards is the deck to divide
     */

    private static void divideDeck(ArrayList<Card> pOneDeck , ArrayList<Card> pTwoDeck , DeckOfCards deckOfCards)
    {
        for(int i=0;i<NUMBER_OF_CARDS;i++)
        {
            if(i%2 == 0)
                pOneDeck.add(deckOfCards.dealCard());
            else
                pTwoDeck.add(deckOfCards.dealCard());
        }


    }
    /*
     * Adds the dealt cards into to winner's deck
     * @param playerDeck is the deck of the player to add the cards to
     * @param pOneCard - is player's one card.
     * @param pTwoCard - is player's two card
     * @param warCards - is both players war cards - if there is war else empty
     */

    private static void addCardsToDeck(ArrayList<Card> playerDeck ,Card pOneCard , Card pTwoCard, ArrayList<Card> warCards){

        playerDeck.add(pOneCard);
        playerDeck.add(pTwoCard);
        playerDeck.addAll(warCards);
        warCards.clear();

    }
    /*
     *Checks Which of the players has 0 cards left and declares the other as winner
     * @param pOneDeck is player's one deck
     * @param pTwoDeck is player's two deck
     */

    private static void declareWinner(ArrayList<Card> pOneDeck , ArrayList<Card> pTwoDeck)
    {
        if(pOneDeck.isEmpty())
        {
            JOptionPane.showMessageDialog(null , "PLAYER TWO WINS THE GAME" );
        }
        else if(pTwoDeck.isEmpty()) {
            JOptionPane.showMessageDialog(null , "PLAYER ONE WINS THE GAME" );
        }


    }
}